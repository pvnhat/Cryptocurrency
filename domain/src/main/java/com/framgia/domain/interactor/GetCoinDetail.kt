package com.framgia.domain.interactor

import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCoinDetail @Inject constructor(private val iCoinRepository: ICoinRepository,
                                        threadExecutor: ThreadExecutor,
                                        threadPostExecutorThread: PostExecutorThread) :
        BaseUseCase<MoreCoin, String>() {
    override fun buildUseCaseObservable(params: String): Observable<MoreCoin> {
        return iCoinRepository.getCoinDetail(params)
    }
}