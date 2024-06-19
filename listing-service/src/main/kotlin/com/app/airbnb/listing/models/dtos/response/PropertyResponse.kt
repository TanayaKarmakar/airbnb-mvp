package com.app.airbnb.listing.models.dtos.response

import com.app.airbnb.listing.models.entities.Address
import com.app.airbnb.listing.models.enums.AmenityType
import com.app.airbnb.listing.models.enums.PropertyType

data class PropertyResponse(
        val id: String,
        val title: String,
        val description: String,
        val address: Address,
        val rating: Double,
        val propertyType: PropertyType,
        val photos: List<String>?,
        val amenities: List<AmenityType>
)