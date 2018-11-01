package com.framgia.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoreCoinInfoData {
    @SerializedName("status")
    @Expose
    var status: StatusData? = null
    @SerializedName("data")
    @Expose
    var data: Map<String, CoinInfoResultData>? = null

    /**
     * No args constructor for use in serialization
     */
    constructor() {}

    /**
     *
     * @param status
     * @param data
     */
    constructor(status: StatusData, data: Map<String, CoinInfoResultData>) : super() {
        this.status = status
        this.data = data
    }
}
