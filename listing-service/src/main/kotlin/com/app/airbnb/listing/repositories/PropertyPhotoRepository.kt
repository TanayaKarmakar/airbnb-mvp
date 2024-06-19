package com.app.airbnb.listing.repositories

import com.app.airbnb.listing.models.entities.PropertyPhoto
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyPhotoRepository: JpaRepository<PropertyPhoto, String> {
}