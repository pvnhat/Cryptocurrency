package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuoteData {
  @SerializedName("USD")
  @Expose
  var usd: UsdData? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   * @param uSD
   */
  constructor(uSD: UsdData) : super() {
    this.usd = uSD
  }
}
