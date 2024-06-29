package com.app.airbnb.listing.models.entities

import com.app.airbnb.listing.models.enums.Rating
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne


@Entity
class PropertyReview(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String,
        val reviewedBy: String,
        var reviewTitle: String,
        var reviewDescription: String,
        var createdAt: Long?,
        var lastUpdatedAt: Long,
        var rating: Rating,
        var isActive: Boolean
)