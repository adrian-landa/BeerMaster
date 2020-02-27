package mx.albo.beermaster.data.entity

import com.squareup.moshi.Json

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    @field:Json(name = "first_brewed")
    val firstBrewed: String,
    val description: String,
    @field:Json(name = "image_url")
    val imageUrl: String,
    val abv: Double,
    val ibu: Int,
    @field:Json(name = "target_fg")
    val target_fg: Int,
    @field:Json(name = "target_og")
    val target_og: Int,
    val ebc: Int,
    val srm: Int,
    val ph: Double,
    val attenuationLevel: Int,
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
    val contributed_by: String
)