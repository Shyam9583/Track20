package com.pce.android.track20.data.network.response


import com.google.gson.annotations.SerializedName
import java.util.*

data class Country(
    @SerializedName("Country")
    val country: String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("Date")
    val date: Date,
    @SerializedName("NewConfirmed")
    val newConfirmed: Long,
    @SerializedName("NewDeaths")
    val newDeaths: Long,
    @SerializedName("NewRecovered")
    val newRecovered: Long,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Long,
    @SerializedName("TotalDeaths")
    val totalDeaths: Long,
    @SerializedName("TotalRecovered")
    val totalRecovered: Long
)