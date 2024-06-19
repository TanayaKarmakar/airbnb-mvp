package com.app.airbnb.listing.services

import com.app.airbnb.listing.models.entities.PropertyPhoto
import com.app.airbnb.listing.repositories.PropertyPhotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

interface PhotoUploadService {
    fun uploadPhotos(): List<String>

    fun buildPropertyPhoto(photoUrls: List<String>): List<PropertyPhoto>

    fun savePhotos(photos: List<PropertyPhoto>): List<PropertyPhoto>
}

@Service
class PhotoUploadServiceImpl(@Autowired
                             val propertyPhotoRepository: PropertyPhotoRepository): PhotoUploadService {
    override fun uploadPhotos(): List<String> {
        return listOf("abc.jpg","def.jpg","ghi.jpg")
    }

    override fun buildPropertyPhoto(photoUrls: List<String>): List<PropertyPhoto> {
        return photoUrls.map { PropertyPhoto(UUID.randomUUID().toString(), it) }
                .toList()
    }

    override fun savePhotos(photos: List<PropertyPhoto>): List<PropertyPhoto> {
        return propertyPhotoRepository.saveAll(photos)
    }

}

