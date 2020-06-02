package com.pce.android.track20.data.network.response


import com.google.gson.annotations.SerializedName
import java.util.*

data class CountryTotalResponseItem(
    @SerializedName("Active")
    val active: Long,
    @SerializedName("Confirmed")
    val confirmed: Long,
    @SerializedName("Country")
    val country: String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("Date")
    val date: Date,
    @SerializedName("Deaths")
    val deaths: Long,
    @SerializedName("Recovered")
    val recovered: Long
)