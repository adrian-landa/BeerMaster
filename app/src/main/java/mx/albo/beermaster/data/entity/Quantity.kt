package mx.albo.beermaster.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quantity(val value:Float?, val unit:String?) : Parcelable