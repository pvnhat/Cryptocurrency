package com.framgia.domain.entity

class Usd {
  var price: Double? = null
  var volume24h: Double? = null
  var percentChange1h: Double? = null
  var percentChange24h: Double? = null
  var percentChange7d: Double? = null
  var marketCap: Double? = null
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
