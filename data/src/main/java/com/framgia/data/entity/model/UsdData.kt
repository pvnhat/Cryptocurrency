package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsdData {
  @SerializedName("price")
  @Expose
  var price: Double? = null
  @SerializedName("volume_24h")
  @Expose
  var volume24h: Double? = null
  @SerializedName("percent_change_1h")
  @Expose
  var percentChange1h: Double? = null
  @SerializedName("percent_change_24h")
  @Expose
  var percentChange24h: Double? = null
  @SerializedName("percent_change_7d")
  @Expose
  var percentChange7d: Double? = null
  @SerializedName("market_cap")
  @Expose
  var marketCap: Double? = null
  @SerializedName("last_updated")
  @Expose
  var lastUpdated: String? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param marketCap
   * @param percentChange24h
   * @param volume24h
   * @param price
   * @param percentChange7d
   * @param lastUpdated
   * @param percentChange1h
   */
  constructor(price: Double?, volume24h: Double?, percentChange1h: Double?,
      percentChange24h: Double?,
      percentChange7d: Double?, marketCap: Double?, lastUpdated: String) : super() {
    this.price = price
    this.volume24h = volume24h
    this.percentChange1h = percentChange1h
    this.percentChange24h = percentChange24h
    this.percentChange7d = percentChange7d
    this.marketCap = marketCap
    this.lastUpdated = lastUpdated
  }
}
