package com.framgia.data.entity.mapper

import com.framgia.data.di.scope.AppScope
import com.framgia.data.entity.model.CoinData
import com.framgia.domain.entity.Coin
import javax.inject.Inject

@AppScope
class CoinDataMapper @Inject constructor() {

  fun transform(coinData: CoinData?): Coin? { //co the tra ve null
    var coin: Coin? = null
    if (coinData == null) {
      return null
    }
    coin = Coin()
    coin.id = coinData.id
    coin.name = coinData.name
    coin.symbol = coinData.symbol
    coin.slug = coinData.slug
    coin.isActive = coinData.isActive
    coin.firstHistoricalData = coinData.firstHistoricalData
    coin.lastHistoricalData = coinData.lastHistoricalData
    return coin
  }
}
