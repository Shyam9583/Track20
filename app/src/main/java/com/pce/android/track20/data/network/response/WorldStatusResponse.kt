package com.pce.android.track20.data.network.response


import com.google.gson.annotations.SerializedName
import java.util.*

data class WorldStatusResponse(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Date")
    val date: Date,
    @SerializedName("Global")
    val global: Global
)