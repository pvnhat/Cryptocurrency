package com.framgia.domain.interactor

import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase<T, Params>() {
  private lateinit var mThreadExecutor: ThreadExecutor
  private lateinit var mPostExecutorThread: PostExecutorThread
  private lateinit var mCompositeDisposable: CompositeDisposable

  constructor(threadExecutor: ThreadExecutor,
      postExecutorThread: PostExecutorThread, compositeDisposable: CompositeDisposable) : this() {
    mThreadExecutor = threadExecutor
    mPostExecutorThread = postExecutorThread
    mCompositeDisposable = compositeDisposable
  }

  abstract fun buildUseCaseObservable(params: Params): Observable<T>

  public fun execute(observer: DisposableObserver<T>, params: Params) {
    val observable: Observable<T> = this.buildUseCaseObservable(params).subscribeOn(
        Schedulers.from(mThreadExecutor))
        .observeOn(mPostExecutorThread.getScheduler())
    addDisposable(observable.subscribeWith(observer))
  }

  public fun addDisposable(disposable: Disposable) {
    mCompositeDisposable.add(disposable)
  }

  public fun onDispose() {
    if (!mCompositeDisposable.isDisposed) {
      mCompositeDisposable.dispose()
    }
  }


}
