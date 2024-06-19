package com.app.airbnb.listing.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class PropertyBooking(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String,
        @ManyToOne
        val property: Property,
        val fromDate: Long,
        val toDate: Long,
        val bookedBy: String
)