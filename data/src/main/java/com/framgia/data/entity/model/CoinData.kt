package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinData {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  @SerializedName("name")
  @Expose
  var name: String? = null
  @SerializedName("symbol")
  @Expose
  var symbol: String? = null
  @SerializedName("slug")
  @Expose
  var slug: String? = null
  @SerializedName("is_active")
  @Expose
  var isActive: Int? = null
  @SerializedName("first_historical_data")
  @Expose
  var firstHistoricalData: String? = null
  @SerializedName("last_historical_data")
  @Expose
  var lastHistoricalData: String? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param firstHistoricalData
   * @param isActive
   * @param id
   * @param symbol
   * @param name
   * @param lastHistoricalData
   * @param slug
   */
  constructor(id: Int?, name: String, symbol: String, slug: String, isActive: Int?,
      firstHistoricalData: String, lastHistoricalData: String) : super() {
    this.id = id
    this.name = name
    this.symbol = symbol
    this.slug = slug
    this.isActive = isActive
    this.firstHistoricalData = firstHistoricalData
    this.lastHistoricalData = lastHistoricalData
  }
}
