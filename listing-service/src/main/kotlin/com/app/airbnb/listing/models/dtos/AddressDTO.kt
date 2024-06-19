package com.app.airbnb.listing.models.dtos

data class AddressDTO(
        val id: String?,
        val city: String,
        val street: String,
        val zipCode: String,
        val country: String
)
