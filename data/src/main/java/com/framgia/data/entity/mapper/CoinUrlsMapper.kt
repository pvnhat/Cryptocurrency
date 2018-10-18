package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinUrls
import com.framgia.data.entity.model.CoinUrlsData
import javax.inject.Inject

class CoinUrlsMapper @Inject constructor() {
  fun transform(coinUrlsData: CoinUrlsData?): CoinUrls? {
    var coinUrls: CoinUrls? = null
    if (coinUrlsData == null) {
      return null
    }
    coinUrls = CoinUrls()
    coinUrls.website = coinUrlsData.website
    coinUrls.twitter = coinUrlsData.twitter
    coinUrls.reddit = coinUrlsData.reddit
    coinUrls.messageBoard = coinUrlsData.messageBoard
    coinUrls.announcement = coinUrlsData.announcement
    coinUrls.chat = coinUrlsData.chat
    coinUrls.explorer = coinUrlsData.explorer
    coinUrls.sourceCode = coinUrlsData.sourceCode
    return coinUrls
  }
}
