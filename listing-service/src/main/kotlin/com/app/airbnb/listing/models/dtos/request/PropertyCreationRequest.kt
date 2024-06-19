package com.app.airbnb.listing.models.dtos.request

import com.app.airbnb.listing.models.dtos.AddressDTO
import com.app.airbnb.listing.models.entities.Address
import com.app.airbnb.listing.models.enums.AmenityType
import com.app.airbnb.listing.models.enums.PropertyType

data class PropertyCreationRequest(
        val id: String?,
        val title: String,
        val description: String,
        val address: Address,
        val propertyType: PropertyType,
        val photos: List<String>,
        val amenities: List<AmenityType>,
        val isActive: Boolean
)