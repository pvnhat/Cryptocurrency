package com.framgia.domain.executor

import io.reactivex.Scheduler

interface PostExecutorThread {
  fun getScheduler(): Scheduler
}