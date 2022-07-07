package com.example.rawfishtest.network

import com.squareup.moshi.Json

data class BeerModel(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val abv: Float,                  //Alcohol by Volume
    val ibu: Float?,                 //International Bitterness Units
    val ebc: Float?,                 //European Brewery Convention (colour-Europe)
    val srm: Float?,                 //Standard Reference Method (colour-America)
    val ph: Float?,                  //Acidity
    val volume: Volume,
    val method: BrewingMethod,
    val ingredients: Ingredients,
    @Json(name = "first_brewed") val firstBrewed: String,
    @Json(name = "image_url") val imageUrl: String,
    @Json(name = "target_fg") val targetFinalGrav: Float,    //final gravity
    @Json(name = "target_og") val targetOrigGrav: Float,     //original gravity
    @Json(name = "attenuation_level") val attenuationLevel: Float,
    @Json(name = "boil_volume") val boilVolume: Volume,
    @Json(name = "food_pairing") val foodPairing: List<String>,
    @Json(name = "brewers_tips") val brewerTips: String,
    @Json(name = "contributed_by") val contributedBy: String,
    //the url to the specific beer, needed for the AreContentsTheSame check in OverviewViewModel
)

//region Brewing method classes
data class BrewingMethod(
    @Json(name = "mash_temp") val mashTemp: List<MashTemp>?,
    val fermentation: FermTemperature,
    val twist: String?
)

data class FermTemperature(
    val temp: Temp
)

data class MashTemp(
    val temp: Temp,
    val duration: Int?
)
//endregion

//region Ingredients classes
data class Ingredients(
    val malt: List<Malt>,
    val hops: List<Hop>,
    val yeast: String
)

data class Malt(
    val name: String,
    val amount: Weight,
)

data class Hop(
    val name: String,
    val amount: Weight,
    val add: String,         //when to add the hop
    val attribute: String
)
//endregion

//region shared classes
data class Volume(
    val value: Int,
    val unit: String
)

data class Temp(
    val value: Float,
    val unit: String
)

data class Weight(
    val value: Float,
    val unit: String
)
//endregion
