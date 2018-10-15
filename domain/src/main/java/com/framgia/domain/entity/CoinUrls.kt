package com.framgia.data.entity.model

class CoinUrls {
  var website: List<String>? = null
  var twitter: List<Any>? = null
  var reddit: List<String>? = null
  var messageBoard: List<String>? = null
  var announcement: List<Any>? = null
  var chat: List<Any>? = null
  var explorer: List<String>? = null
  var sourceCode: List<String>? = null

  /**
   * No args constructor for use in serialization
   */
  constructor() {}

  /**
   *
   * @param messageBoard
   * @param twitter
   * @param explorer
   * @param announcement
   * @param sourceCode
   * @param website
   * @param reddit
   * @param chat
   */
  constructor(website: List<String>, twitter: List<Any>, reddit: List<String>,
      messageBoard: List<String>, announcement: List<Any>, chat: List<Any>,
      explorer: List<String>, sourceCode: List<String>) : super() {
    this.website = website
    this.twitter = twitter
    this.reddit = reddit
    this.messageBoard = messageBoard
    this.announcement = announcement
    this.chat = chat
    this.explorer = explorer
    this.sourceCode = sourceCode
  }
}
