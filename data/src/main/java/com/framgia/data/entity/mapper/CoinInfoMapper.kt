package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinInfoResultData
import com.framgia.domain.entity.CoinInfoResult
import javax.inject.Inject

class CoinInfoMapper @Inject constructor(private val coinUrlsMapper: CoinUrlsMapper) {
    fun transform(coinInfoResultData: CoinInfoResultData?): CoinInfoResult? {
        var coinInfoResult: CoinInfoResult? = null
        if (coinInfoResultData == null) {
            return null
        }
        coinInfoResult = CoinInfoResult()
        coinInfoResult.urls = coinUrlsMapper.transform(coinInfoResultData.urls)
        coinInfoResult.id = coinInfoResultData.id
        coinInfoResult.logo = coinInfoResultData.logo
        coinInfoResult.name = coinInfoResultData.symbol
        coinInfoResult.slug = coinInfoResultData.slug
        coinInfoResult.dateAdded = coinInfoResultData.dateAdded
        coinInfoResult.tags = coinInfoResultData.tags
        coinInfoResult.category = coinInfoResultData.category
        return coinInfoResult
    }
}
