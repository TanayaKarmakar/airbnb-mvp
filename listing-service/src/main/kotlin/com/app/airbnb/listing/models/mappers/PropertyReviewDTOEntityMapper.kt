package com.app.airbnb.listing.models.mappers

import com.app.airbnb.listing.models.dtos.request.PropertyReviewRequest
import com.app.airbnb.listing.models.dtos.response.PropertyReviewResponse
import com.app.airbnb.listing.models.entities.Property
import com.app.airbnb.listing.models.entities.PropertyReview
import java.util.*

object PropertyReviewDTOEntityMapper {
    fun toPropertyReviewEntity(propertyReviewRequest: PropertyReviewRequest): PropertyReview {
        val propertyReview = PropertyReview(
                "null",
                propertyReviewRequest.reviewedBy,
                propertyReviewRequest.reviewTitle,
                propertyReviewRequest.reviewDescription,
                null,
                System.currentTimeMillis(),
                propertyReviewRequest.rating,
                false
        )
        return propertyReview
    }

    fun toPropertyReviewResponse(property: Property): PropertyReviewResponse {
        return PropertyReviewResponse(
               property.id,
                property.title,
                property.description,
                property.propertyReviews!!
        )
    }




    private fun assignId(propertyReviewRequest: PropertyReviewRequest): String {
        if(propertyReviewRequest.id == null)
            return UUID.randomUUID().toString()
        return propertyReviewRequest.id
    }
 }