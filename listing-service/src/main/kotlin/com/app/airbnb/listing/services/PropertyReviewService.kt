package com.app.airbnb.listing.services

import com.app.airbnb.listing.exception.BadRequestException
import com.app.airbnb.listing.exception.NotFoundException
import com.app.airbnb.listing.models.dtos.request.PropertyReviewRequest
import com.app.airbnb.listing.models.entities.Property
import com.app.airbnb.listing.models.entities.PropertyReview
import com.app.airbnb.listing.models.mappers.PropertyReviewDTOEntityMapper
import com.app.airbnb.listing.repositories.PropertyRepository
import com.app.airbnb.listing.repositories.PropertyReviewRepository
import com.app.airbnb.listing.utils.AppConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface PropertyReviewService {
    fun addReviewForAProperty(
            propertyId: String,
            propertyReviewRequest: PropertyReviewRequest
    ): Property

    fun getReviewsForAProperty(
            propertyId: String
    ): Property

    fun updateReviewForAProperty(
            propertyReviewRequest: PropertyReviewRequest
    ): PropertyReview

    fun deleteReviewsForAProperty(
            propertyId: String,
            reviewId: String
    )
}

@Service
class PropertyReviewServiceImpl(
        @Autowired
        val propertyReviewRepository: PropertyReviewRepository,
        @Autowired
        val propertyService: PropertyService,
        @Autowired
        val propertyRepository: PropertyRepository
): PropertyReviewService {
    override fun addReviewForAProperty(
            propertyId: String,
            propertyReviewRequest: PropertyReviewRequest): Property{
        val property = propertyService.getPropertyById(propertyId)
        val propertyReview = PropertyReviewDTOEntityMapper.toPropertyReviewEntity(propertyReviewRequest)
        propertyReview.isActive = true
        propertyReview.createdAt = System.currentTimeMillis()
        if(property.propertyReviews.isNullOrEmpty()) {
            property.propertyReviews = mutableListOf()
        }
        property.propertyReviews!!.add(propertyReview)
        return propertyRepository.save(property)
    }

    override fun getReviewsForAProperty(
            propertyId: String
    ): Property {
        val property = propertyService.getPropertyById(propertyId)
        val propertyReviews = property.propertyReviews?.filter { it.isActive }?.toMutableList()
        property.propertyReviews = propertyReviews
        return property
    }

    override fun updateReviewForAProperty(
            propertyReviewRequest: PropertyReviewRequest
    ): PropertyReview {
        val propertyReviewOpt = propertyReviewRequest.id?.let { propertyReviewRepository.findById(it) }
        if (propertyReviewOpt != null) {
            if(!propertyReviewOpt.isPresent) {
                throw NotFoundException("${AppConstants.NOT_FOUND} with Review ID ${propertyReviewRequest.id}" )
            }

            val propertyReview = propertyReviewOpt.get()

            propertyReview.reviewTitle = propertyReviewRequest.reviewTitle
            propertyReview.reviewDescription = propertyReviewRequest.reviewDescription
            propertyReview.rating = propertyReviewRequest.rating
            propertyReview.lastUpdatedAt = System.currentTimeMillis()
            val updatedPropertyReview = propertyReviewRepository.save(propertyReview)
            return updatedPropertyReview
        }
        throw BadRequestException(AppConstants.BAD_REQUEST)

    }

    override fun deleteReviewsForAProperty(
            propertyId: String,
            reviewId: String
    ) {
        propertyService.getPropertyById(propertyId)
        val propertyReviewOpt = propertyReviewRepository.findById(reviewId)
        if(propertyReviewOpt.isEmpty || !propertyReviewOpt.get().isActive) {
            throw NotFoundException("${AppConstants.NOT_FOUND} with Review ID ${reviewId}")
        }
        val propertyReview = propertyReviewOpt.get()
        propertyReview.isActive = false
        propertyReviewRepository.save(propertyReview)
    }

}