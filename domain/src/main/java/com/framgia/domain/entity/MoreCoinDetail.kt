package com.framgia.domain.entity

class MoreCoinDetail {
  var status: Status? = null
  var listCoin: List<CoinDetailResult>? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param status
   * @param data
   */
  constructor(status: Status, listCoin: List<CoinDetailResult>) {
    this.status = status
    this.listCoin = listCoin
  }
}
