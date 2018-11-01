package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinDetailResultData
import com.framgia.domain.entity.CoinDetailResult
import javax.inject.Inject

class CoinDetailMapper @Inject constructor(private val quoteMapper: QuoteMapper) {


  fun transform(coinDetailResultData: CoinDetailResultData?): CoinDetailResult? {
    var coinDetailResult: CoinDetailResult?
    if (coinDetailResultData == null) {
      return null
    }
    coinDetailResult = CoinDetailResult()
    coinDetailResult.id = coinDetailResultData.id
    coinDetailResult.name = coinDetailResultData.name
    coinDetailResult.symbol = coinDetailResultData.symbol
    coinDetailResult.slug = coinDetailResultData.slug
    coinDetailResult.circulatingSupply = coinDetailResultData.circulatingSupply
    coinDetailResult.totalSupply = coinDetailResultData.totalSupply
    coinDetailResult.maxSupply = coinDetailResultData.maxSupply
    coinDetailResult.dateAdded = coinDetailResultData.dateAdded
    coinDetailResult.numMarketPairs = coinDetailResultData.numMarketPairs
    coinDetailResult.cmcRank = coinDetailResultData.cmcRank
    coinDetailResult.lastUpdated = coinDetailResultData.lastUpdated
    coinDetailResult.quote = quoteMapper.transform(coinDetailResultData.quote)
    return coinDetailResult
  }


  fun transform(list: List<CoinDetailResultData>?): List<CoinDetailResult>? {
    if (list == null) {
      return null
    }
    var listCoinDetailResult = ArrayList<CoinDetailResult>()
    for (coinData in list) {
      val coin: CoinDetailResult = this.transform(coinData)!!
      listCoinDetailResult.add(coin)
    }
    return listCoinDetailResult
  }
}
