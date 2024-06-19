package com.app.airbnb.listing.services

import org.springframework.beans.factory.annotation.Autowired

interface PropertyReviewService {
    fun addReviewForAProperty()

    fun getReviewsForAProperty()

    fun updateReviewForAProperty()

    fun deleteReviewsForAProperty()
}

class PropertyReviewServiceImpl(
        @Autowired
        val propertyReviewService: PropertyReviewService
): PropertyReviewService {
    override fun addReviewForAProperty() {
        TODO("Not yet implemented")
    }

    override fun getReviewsForAProperty() {
        TODO("Not yet implemented")
    }

    override fun updateReviewForAProperty() {
        TODO("Not yet implemented")
    }

    override fun deleteReviewsForAProperty() {
        TODO("Not yet implemented")
    }

}