package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoreCoinDetailData {
  @SerializedName("status")
  @Expose
  var status: StatusData? = null
  @SerializedName("data")
  @Expose
  var listCoin: List<CoinDetailResultData>? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param status
   * @param data
   */
  constructor(status: StatusData, listCoin: List<CoinDetailResultData>) {
    this.status = status
    this.listCoin = listCoin
  }
}
