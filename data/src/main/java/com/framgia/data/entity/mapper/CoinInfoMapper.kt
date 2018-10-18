package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinInfoResultData
import com.framgia.domain.entity.CoinInfoResult
import javax.inject.Inject

class CoinInfoMapper @Inject constructor() {
  fun transform(coinInfoResultData: CoinInfoResultData?): CoinInfoResult? {
    var coinInfoResult: CoinInfoResult? = null
    if (coinInfoResultData == null) {
      return null
    }
    coinInfoResult = CoinInfoResult()
    coinInfoResult.urls = coinInfoResult.urls
    coinInfoResult.id = coinInfoResult.id
    coinInfoResult.logo = coinInfoResult.logo
    coinInfoResult.name = coinInfoResult.symbol
    coinInfoResult.slug = coinInfoResult.slug
    coinInfoResult.dateAdded = coinInfoResult.dateAdded
    coinInfoResult.tags = coinInfoResult.tags
    coinInfoResult.category = coinInfoResult.category
    return coinInfoResult
  }
}
