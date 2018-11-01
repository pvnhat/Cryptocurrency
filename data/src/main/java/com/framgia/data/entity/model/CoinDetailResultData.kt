package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinDetailResultData {
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
    @SerializedName("circulating_supply")
    @Expose
    var circulatingSupply: Double? = null
    @SerializedName("total_supply")
    @Expose
    var totalSupply: Double? = null
    @SerializedName("max_supply")
    @Expose
    var maxSupply: Any? = null
    @SerializedName("date_added")
    @Expose
    var dateAdded: String? = null
    @SerializedName("num_market_pairs")
    @Expose
    var numMarketPairs: Int? = null
    @SerializedName("cmc_rank")
    @Expose
    var cmcRank: Int? = null
    @SerializedName("last_updated")
    @Expose
    var lastUpdated: String? = null
    @SerializedName("quote")
    @Expose
    var quote: QuoteData? = null

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
                cmcRank: Int?, lastUpdated: String, quote: QuoteData) : super() {
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
