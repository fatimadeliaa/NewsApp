package com.iyaliyul.newsssapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceItem(
    val id: String? = null,
    val name: String = ""
): Parcelable