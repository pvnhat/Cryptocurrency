package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.UsdData
import com.framgia.domain.entity.Usd
import javax.inject.Inject

class UsdMapper @Inject constructor() {
  fun transform(usdData: UsdData?): Usd? {
    if (usdData == null) {
      return null
    }
    val usd = Usd()
    usd.price = usdData.price
    usd.volume24h = usdData.volume24h
    usd.percentChange1h = usdData.percentChange1h
    usd.percentChange24h = usdData.percentChange24h
    usd.percentChange7d = usdData.percentChange7d
    usd.marketCap = usdData.marketCap
    usd.lastUpdated = usdData.lastUpdated
    return usd
  }
}