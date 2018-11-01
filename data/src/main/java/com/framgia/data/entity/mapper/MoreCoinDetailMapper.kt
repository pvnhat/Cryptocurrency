package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.MoreCoinDetailData
import com.framgia.domain.entity.MoreCoinDetail
import javax.inject.Inject

class MoreCoinDetailMapper @Inject constructor(private val statusMapper: StatusMapper,
    private val coinDetailMapper: CoinDetailMapper) {

  fun transform(moreCoinData: MoreCoinDetailData?): MoreCoinDetail? {
    if (moreCoinData == null) {
      return null
    }
    return MoreCoinDetail(status = statusMapper.transform(moreCoinData.status)!!,
        listCoin = coinDetailMapper.transform(moreCoinData.listCoin)!!)
  }
}
