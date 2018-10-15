package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinUrlsData {
  @SerializedName("website")
  @Expose
  var website: List<String>? = null
  @SerializedName("twitter")
  @Expose
  var twitter: List<Any>? = null
  @SerializedName("reddit")
  @Expose
  var reddit: List<String>? = null
  @SerializedName("message_board")
  @Expose
  var messageBoard: List<String>? = null
  @SerializedName("announcement")
  @Expose
  var announcement: List<Any>? = null
  @SerializedName("chat")
  @Expose
  var chat: List<Any>? = null
  @SerializedName("explorer")
  @Expose
  var explorer: List<String>? = null
  @SerializedName("source_code")
  @Expose
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
