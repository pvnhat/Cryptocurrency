package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinInfoResultData {
  @SerializedName("urls")
  @Expose
  var urls: CoinUrlsData? = null
  @SerializedName("logo")
  @Expose
  var logo: String? = null
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
  @SerializedName("date_added")
  @Expose
  var dateAdded: String? = null
  @SerializedName("tags")
  @Expose
  var tags: List<String>? = null
  @SerializedName("category")
  @Expose
  var category: String? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param tags
   * @param id
   * @param logo
   * @param category
   * @param symbol
   * @param urls
   * @param name
   * @param dateAdded
   * @param slug
   */
  constructor(urls: CoinUrlsData, logo: String, id: Int?, name: String, symbol: String,
      slug: String, dateAdded: String, tags: List<String>, category: String) : super() {
    this.urls = urls
    this.logo = logo
    this.id = id
    this.name = name
    this.symbol = symbol
    this.slug = slug
    this.dateAdded = dateAdded
    this.tags = tags
    this.category = category
  }
}
