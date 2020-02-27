package mx.albo.beermaster.data.entity

import com.squareup.moshi.Json

data class Method(
    @field:Json(name = "mash_temp")
    val mashTemp: List<MashTemp>,
    val fermentation: Fermentation,
    val twist: String
)