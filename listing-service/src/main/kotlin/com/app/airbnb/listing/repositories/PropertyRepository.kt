package com.app.airbnb.listing.repositories

import com.app.airbnb.listing.models.entities.Property
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyRepository: JpaRepository<Property, String> {
}