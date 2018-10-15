package com.framgia.domain.entity

class Coin {
  var id: Int? = null
  var name: String? = null
  var symbol: String? = null
  var slug: String? = null
  var isActive: Int? = null
  var firstHistoricalData: String? = null
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