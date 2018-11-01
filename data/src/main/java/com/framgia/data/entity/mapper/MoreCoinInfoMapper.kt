package com.framgia.data.entity.mapper

import android.os.Build
import android.support.annotation.RequiresApi
import com.framgia.data.entity.model.MoreCoinInfoData
import com.framgia.domain.entity.MoreCoinInfo
import java.util.stream.Collectors
import javax.inject.Inject

class MoreCoinInfoMapper @Inject constructor(private val statusMapper: StatusMapper, private val
coinInForeMapper: CoinInfoMapper) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun transform(moreCoinInfoData: MoreCoinInfoData?): MoreCoinInfo? {
        if (moreCoinInfoData == null) {
            return null
        }
        return MoreCoinInfo(status = statusMapper.transform(moreCoinInfoData.status),
                data = moreCoinInfoData.data?.entries?.stream()?.collect(Collectors.toMap({ e -> e.key },
                        { e -> coinInForeMapper.transform(e.value) }
                )))
    }
}
