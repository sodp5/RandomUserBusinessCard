
package com.munny.randomuserbusinesscard.api.response

data class RandomUserResponse(
    val results: List<Result>
) {
    data class Result(
        val name: Name,
        val location: Location,
        val email: String,
        val phone: String,
        val picture: Picture
    )

    data class Name(
        val title: String,
        val first: String,
        val last: String
    )

    data class Location(
        val city: String,
        val country: String
    )

    data class Picture(
        val medium: String
    )
}