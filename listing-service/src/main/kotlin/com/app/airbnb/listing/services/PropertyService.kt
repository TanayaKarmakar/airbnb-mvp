package com.app.airbnb.listing.services

import com.app.airbnb.listing.exception.NotFoundException
import com.app.airbnb.listing.models.dtos.request.PropertyCreationRequest
import com.app.airbnb.listing.models.entities.Property
import com.app.airbnb.listing.models.mappers.PropertyDTOEntityMapper
import com.app.airbnb.listing.repositories.PropertyRepository
import com.app.airbnb.listing.utils.AppConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface PropertyService {
    fun getPropertyById(propertyId: String): Property

    fun addProperty(propertyRequest: PropertyCreationRequest): Property

    fun updateProperty(): Property

    fun deleteProperty(): Property
}

@Service
class PropertyServiceImpl(
        @Autowired val propertyRepository: PropertyRepository,
        @Autowired val photoUploadService: PhotoUploadService
        ): PropertyService {
    override fun getPropertyById(propertyId: String): Property =
        propertyRepository.findById(propertyId)
                .map{it}
                .orElse(throw NotFoundException(AppConstants.NOT_FOUND))

    override fun addProperty(propertyRequest: PropertyCreationRequest): Property {
        val photoUrls = photoUploadService.uploadPhotos()
        val propertyPhotos = photoUploadService.buildPropertyPhoto(photoUrls)
        val property = PropertyDTOEntityMapper.toPropertyEntity(propertyRequest, propertyPhotos)
        propertyRepository.save(property)
        return property
    }

    override fun updateProperty(): Property {
        TODO("Not yet implemented")
    }

    override fun deleteProperty(): Property {
        TODO("Not yet implemented")
    }

}