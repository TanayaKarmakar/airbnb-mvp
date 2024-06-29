package com.app.airbnb.listing.models.dtos.response

import com.app.airbnb.listing.models.entities.PropertyReview

data class PropertyReviewResponse(
        val propertyId: String,
        val propertyTitle: String,
        val propertyDescription: String,
        val propertyReviews: List<PropertyReview>
)
