package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinDetailResultData
import com.framgia.data.entity.model.MoreCoinData
import com.framgia.domain.entity.CoinDetailResult
import com.framgia.domain.entity.MoreCoin
import javax.inject.Inject

class MoreCoinMapper @Inject constructor(private val statusMapper: StatusMapper, private val coinDetailMapper: CoinDetailMapper) {

    fun transform(moreCoinData: MoreCoinData?): MoreCoin? {
        if (moreCoinData == null) {
            return null
        }
        return MoreCoin(status = statusMapper.transform(moreCoinData.status),
                data = mapValue(moreCoinData.data!!))
    }

    /**
     * map tu CoinDetailResultData sang COinDetailResult
     */
    private fun mapValue(map: Map<String, CoinDetailResultData>): HashMap<String, CoinDetailResult> {
        val mapResult = HashMap<String, CoinDetailResult>()
        for (e in map.keys) {
            mapResult.put(e, coinDetailMapper.transform(map[e]) ?: CoinDetailResult())
        }

        return mapResult
    }
}
