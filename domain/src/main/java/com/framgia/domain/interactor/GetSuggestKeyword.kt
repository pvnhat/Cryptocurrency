package com.framgia.domain.interactor

import com.framgia.domain.entity.CoinSuggestKeyword
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by GianhTran on 16/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */
class GetSuggestKeyword @Inject constructor(private val iCoinRepository: ICoinRepository,
                                            val threadExecutor: ThreadExecutor,
                                            val threadPostExecutorThread: PostExecutorThread) {

    fun buildUseCaseObservable(symbol: String): Flowable<List<CoinSuggestKeyword>> {
        return iCoinRepository.getKeywordFromDB(symbol)

    }

    fun execute(params: String): Flowable<List<CoinSuggestKeyword>> {
        return this.buildUseCaseObservable(params).subscribeOn(
                Schedulers.from(threadExecutor))
                .observeOn(threadPostExecutorThread.getScheduler())
    }

}
