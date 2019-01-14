package com.loyalty.vendor.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomerSheetUIModel(
        val name: String,
        val imageUrl: String,
        val points: Int
) : Parcelable