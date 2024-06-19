package com.app.airbnb.listing.models.mappers

import com.app.airbnb.listing.models.dtos.AddressDTO
import com.app.airbnb.listing.models.dtos.request.PropertyCreationRequest
import com.app.airbnb.listing.models.dtos.response.PropertyResponse
import com.app.airbnb.listing.models.entities.Address
import com.app.airbnb.listing.models.entities.Property
import com.app.airbnb.listing.models.entities.PropertyPhoto
import com.app.airbnb.listing.models.entities.PropertyReview
import java.util.UUID

object PropertyDTOEntityMapper {
    fun toPropertyResponseDTO(property: Property): PropertyResponse{
        val propertyRating = calculateRating(property.propertyReviews)
        val photoList = property.photos?.map { it.photoUrl }?.toList()

        val propertyResponse = PropertyResponse(
                property.id,
                property.title,
                property.description,
                property.address,
                propertyRating,
                property.propertyType,
                photoList,
                property.amenities

        )
        return propertyResponse
    }

    fun toPropertyEntity(propertyRequest: PropertyCreationRequest, propertyPhotos: List<PropertyPhoto>): Property {

        val property = Property(
                assignId(propertyRequest.id),
                propertyRequest.title,
                propertyRequest.description,
                propertyRequest.address,
                propertyRequest.propertyType,
                propertyPhotos,
                propertyRequest.amenities,
                null,
                null,
                propertyRequest.isActive
        )
        return property
    }

    fun toAddressEntity(address: AddressDTO): Address {
        val id = assignId(address.id)

        return Address(
                address.city,
                address.street,
                address.zipCode,
                address.country
        )
    }

    private fun assignId(id: String?): String {
        if(id != null)
            return id
        return UUID.randomUUID().toString()
    }


    private fun calculateRating(propertyRatings: List<PropertyReview>?): Double {
        return 0.0
    }
}