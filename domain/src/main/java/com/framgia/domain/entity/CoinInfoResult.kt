package com.framgia.domain.entity

import com.framgia.data.entity.model.CoinUrls

class CoinInfoResult {
  var urls: CoinUrls? = null
  var logo: String? = null
  var id: Int? = null
  var name: String? = null
  var symbol: String? = null
  var slug: String? = null
  var dateAdded: String? = null
  var tags: List<String>? = null
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
  constructor(urls: CoinUrls, logo: String, id: Int?, name: String, symbol: String,
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
