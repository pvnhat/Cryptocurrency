package com.framgia.domain.interactor

import com.framgia.domain.entity.CoinDetailResult
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetLastestList @Inject internal constructor(private val iCoinRepository: ICoinRepository, threadExecutor: ThreadExecutor,
    postExecutorThread: PostExecutorThread) : BaseUseCase<MoreCoin<CoinDetailResult>, Int>(
    threadExecutor, postExecutorThread) {
  override fun buildUseCaseObservable(params: Int): Observable<MoreCoin<CoinDetailResult>> {
    return iCoinRepository.getLastestList(params)
  }

}