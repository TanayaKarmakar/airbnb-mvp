package com.app.airbnb.listing.models.entities

import com.app.airbnb.listing.models.enums.PricingType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class PropertyPricing (
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String,
        val pricingType: PricingType,
        val pricingValue: Double
)