package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.StatusData
import com.framgia.domain.entity.Status
import javax.inject.Inject

class StatusMapper @Inject constructor() {
  fun transform(statusData: StatusData?): Status? {
    var status: Status? = null
    if (statusData == null) {
      return null
    }
    return Status(timestamp = statusData.timestamp, errorCode = statusData.errorCode,
        errorMessage = statusData.errorMessage, elapsed = statusData.elapsed,
        creditCount = statusData.creditCount)
  }
}