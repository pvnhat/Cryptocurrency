package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.MoreCoinData
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.entity.Status
import javax.inject.Inject

class MoreCoinMapper @Inject constructor(private val statusMapper: StatusMapper) {

  fun transform(moreCoinData: MoreCoinData<Any>?): MoreCoin<Any>? {
    if (moreCoinData == null) {
      return null
    }
    var status: Status? = null
    return MoreCoin(status = statusMapper.transform(moreCoinData.status), data = moreCoinData.data)
  }
}