package com.framgia.domain.entity

import com.framgia.data.entity.model.Quote


class CoinDetailResult {
  var id: Int? = null
  var name: String? = null
  var symbol: String? = null
  var slug: String? = null

  var circulatingSupply: Double? = null
  var totalSupply: Double? = null
  var maxSupply: Any? = null
  var dateAdded: String? = null
  var numMarketPairs: Int? = null
  var cmcRank: Int? = null
  var lastUpdated: String? = null
  var quote: Quote? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param id
   * @param maxSupply
   * @param circulatingSupply
   * @param symbol
   * @param quote
   * @param name
   * @param lastUpdated
   * @param dateAdded
   * @param slug
   * @param numMarketPairs
   * @param totalSupply
   * @param cmcRank
   */
  constructor(id: Int?, name: String, symbol: String, slug: String, circulatingSupply: Double?,
      totalSupply: Double?, maxSupply: Any, dateAdded: String, numMarketPairs: Int?,
      cmcRank: Int?, lastUpdated: String, quote: Quote) : super() {
    this.id = id
    this.name = name
    this.symbol = symbol
    this.slug = slug
    this.circulatingSupply = circulatingSupply
    this.totalSupply = totalSupply
    this.maxSupply = maxSupply
    this.dateAdded = dateAdded
    this.numMarketPairs = numMarketPairs
    this.cmcRank = cmcRank
    this.lastUpdated = lastUpdated
    this.quote = quote
  }
}
