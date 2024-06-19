package com.app.airbnb.listing.repositories

import com.app.airbnb.listing.models.entities.PropertyReview
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyReviewRepository: JpaRepository<PropertyReview, String> {
}