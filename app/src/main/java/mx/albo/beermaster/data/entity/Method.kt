package mx.albo.beermaster.data.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Method(
    @field:Json(name = "mash_temp")
    val mashTemp: List<MashTemp>,
    val fermentation: Fermentation,
    val twist: String
) : Parcelable