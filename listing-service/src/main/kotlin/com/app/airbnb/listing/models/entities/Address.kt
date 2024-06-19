package com.app.airbnb.listing.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Address(
        val city: String,
        val street: String,
        val zipCode: String,
        val country: String
)
