package com.framgia.domain.interactor

import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class BaseUseCase<T, Params>() {
  @Inject
  lateinit var mThreadExecutor: ThreadExecutor
  @Inject
  lateinit var mPostExecutorThread: PostExecutorThread
  var mCompositeDisposable = CompositeDisposable()


  abstract fun buildUseCaseObservable(params: Params): Observable<T>

  fun execute(observer: DisposableObserver<T>, params: Params) {
    val observable: Observable<T> = this.buildUseCaseObservable(params).subscribeOn(
        Schedulers.from(mThreadExecutor))
        .observeOn(mPostExecutorThread.getScheduler())
    addDisposable(observable.subscribeWith(observer))
  }

  private fun addDisposable(disposable: Disposable) {
    mCompositeDisposable.add(disposable)
  }

  fun onDispose() {
    if (!mCompositeDisposable.isDisposed) {
      mCompositeDisposable.dispose()
    }
  }
}
