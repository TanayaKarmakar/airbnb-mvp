package com.app.airbnb.listing.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class PropertyPhoto(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String,
        val photoUrl: String
)
