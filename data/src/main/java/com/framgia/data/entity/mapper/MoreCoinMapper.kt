package com.framgia.data.entity.mapper

import android.os.Build
import android.support.annotation.RequiresApi
import com.framgia.data.entity.model.MoreCoinData
import com.framgia.domain.entity.MoreCoin
import java.util.stream.Collectors
import javax.inject.Inject

class MoreCoinMapper @Inject constructor(private val statusMapper: StatusMapper, private val coinDetailMapper: CoinDetailMapper) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun transform(moreCoinData: MoreCoinData?): MoreCoin? {
        if (moreCoinData == null) {
            return null
        }
        return MoreCoin(status = statusMapper.transform(moreCoinData.status),
                data = moreCoinData.data?.entries?.stream()?.collect(Collectors.toMap({ e -> e.key },
                        { e -> coinDetailMapper.transform(e.value) }
                )))
    }
}
