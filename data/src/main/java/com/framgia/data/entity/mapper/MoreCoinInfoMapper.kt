package com.framgia.data.entity.mapper

import android.os.Build
import android.support.annotation.RequiresApi
import com.framgia.data.entity.model.CoinInfoResultData
import com.framgia.data.entity.model.MoreCoinInfoData
import com.framgia.domain.entity.CoinInfoResult
import com.framgia.domain.entity.MoreCoinInfo
import javax.inject.Inject

class MoreCoinInfoMapper @Inject constructor(private val statusMapper: StatusMapper, private val
coinInForeMapper: CoinInfoMapper) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun transform(moreCoinInfoData: MoreCoinInfoData?): MoreCoinInfo? {
        if (moreCoinInfoData == null) {
            return null
        }
        return MoreCoinInfo(status = statusMapper.transform(moreCoinInfoData.status),
                data = mapValue(moreCoinInfoData.data!!))
    }

    private fun mapValue(hashMap: Map<String, CoinInfoResultData>): HashMap<String, CoinInfoResult> {
        var mapResult = HashMap<String, CoinInfoResult>()
        for (k in hashMap.keys) {
            mapResult.put(k, coinInForeMapper.transform(hashMap[k]) ?: CoinInfoResult())
        }
        return mapResult
    }
}
