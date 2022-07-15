package com.project.onlinemusicsearch.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SongsResponse(val results: List<SongCatalog>)

@Parcelize
data class SongCatalog(
    val artistName: String,
    val trackName: String,
    val artworkUrl100: String,
    val previewUrl: String,
    val trackPrice: Double
): Parcelable
