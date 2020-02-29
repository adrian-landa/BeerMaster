package mx.albo.beermaster.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hop(val name: String, val amount: Quantity, val add: String, val attribute: String) :
    Parcelable