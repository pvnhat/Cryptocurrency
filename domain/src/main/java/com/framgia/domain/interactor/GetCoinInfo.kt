package com.framgia.domain.interactor

import com.framgia.domain.entity.MoreCoinInfo
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Van Nhat on 01/11/2018.
 */

// inject constructor co tham so se co 2 nv : la provide chinh no voi () , va goi cac tham so da duoc provide truoc do
class GetCoinInfo @Inject constructor(private val iconRepository: ICoinRepository,
                                      threadExecutor: ThreadExecutor,
                                      threadPostExecutorThread: PostExecutorThread)
    : BaseUseCase<MoreCoinInfo, String>() {
    override fun buildUseCaseObservable(params: String): Observable<MoreCoinInfo> {
        return iconRepository.getInfoCoin(params)
    }
}