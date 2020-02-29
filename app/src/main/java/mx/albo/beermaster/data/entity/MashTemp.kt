package mx.albo.beermaster.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MashTemp(val temp: Quantity, val duration: Int?) : Parcelable