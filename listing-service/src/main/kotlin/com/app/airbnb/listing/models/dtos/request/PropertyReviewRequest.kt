package com.app.airbnb.listing.models.dtos.request

import com.app.airbnb.listing.models.enums.Rating

data class PropertyReviewRequest(
        val id: String?,
        val reviewedBy: String,
        val reviewTitle: String,
        val reviewDescription: String,
        val rating: Rating,
        val isActive: Boolean
)
