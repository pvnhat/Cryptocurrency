package com.framgia.domain.interactor

import com.framgia.domain.entity.CoinSuggestKeyword
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import javax.inject.Inject

/**
 * Created by GianhTran on 16/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */
class SaveSuggestKeyword @Inject constructor(private val iCoinRepository: ICoinRepository,
                                             val threadExecutor: ThreadExecutor,
                                             val threadPostExecutorThread: PostExecutorThread) {
    fun buildUseCaseObservable(symbolList: List<CoinSuggestKeyword>) {
        threadExecutor.execute {
            iCoinRepository.saveSymbolToDB(symbolList)
        }
    }
}
