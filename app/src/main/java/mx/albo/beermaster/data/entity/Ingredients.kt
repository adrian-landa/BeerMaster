package mx.albo.beermaster.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredients(val malt: List<Malt>, val hops: List<Hop>) : Parcelable