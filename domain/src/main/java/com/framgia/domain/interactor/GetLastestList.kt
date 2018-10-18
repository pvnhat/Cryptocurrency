package com.framgia.domain.interactor

import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetLastestList @Inject constructor(
        private val iCoinRepository: ICoinRepository,
        threadExecutor: ThreadExecutor,
        postExecutorThread: PostExecutorThread) : BaseUseCase<MoreCoinDetail, Int>() {
    override fun buildUseCaseObservable(params: Int): Observable<MoreCoinDetail> {
        return iCoinRepository.getLastestList(params)
    }

}
