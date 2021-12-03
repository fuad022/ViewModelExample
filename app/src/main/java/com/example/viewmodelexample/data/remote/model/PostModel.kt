package com.example.viewmodelexample.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Parcelable
