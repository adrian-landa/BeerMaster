package mx.albo.beermaster.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fermentation(val temp: Quantity) : Parcelable