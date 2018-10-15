package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StatusData {
  @SerializedName("timestamp")
  @Expose
  var timestamp: String? = null
  @SerializedName("error_code")
  @Expose
  var errorCode: Int? = null
  @SerializedName("error_message")
  @Expose
  var errorMessage: Any? = null
  @SerializedName("elapsed")
  @Expose
  var elapsed: Int? = null
  @SerializedName("credit_count")
  @Expose
  var creditCount: Int? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param elapsed
   * @param errorMessage
   * @param timestamp
   * @param creditCount
   * @param errorCode
   */
  constructor(timestamp: String, errorCode: Int?, errorMessage: Any, elapsed: Int?,
      creditCount: Int?) : super() {
    this.timestamp = timestamp
    this.errorCode = errorCode
    this.errorMessage = errorMessage
    this.elapsed = elapsed
    this.creditCount = creditCount
  }
}
