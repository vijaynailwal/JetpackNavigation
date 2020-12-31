package com.vijay.jetpacknavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


@Parcelize
data class MoneyModel(val amount: BigDecimal) : Parcelable {

}