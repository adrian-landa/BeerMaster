package mx.albo.beermaster.data.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beer(
    val id: Int,
    val name: String,
    val tagline: String?,
    @field:Json(name = "first_brewed")
    val firstBrewed: String?,
    val description: String?,
    @field:Json(name = "image_url")
    val imageUrl: String,
    val abv: Float?,
    val ibu: Float?,
    @field:Json(name = "target_fg")
    val targetFG: Float?,
    @field:Json(name = "target_og")
    val targetOG: Float?,
    val ebc: Float?,
    val srm: Float?,
    val ph: Float?,
    @field:Json(name = "attenuation_level")
    val attenuationLevel: Float?,
    val volume: Volume,
    @field:Json(name = "boil_volume")
    val boilVolume: Volume,
    val method: Method,
    val ingredients: Ingredients,
    @field:Json(name = "food_pairing")
    val foodPairing: List<String>,
    @field:Json(name = "brewers_tips")
    val brewersTips: String,
    @field:Json(name = "contributed_by")
    val contributedBy: String
) : Parcelable