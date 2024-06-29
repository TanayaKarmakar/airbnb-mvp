package com.app.airbnb.listing.controllers

import com.app.airbnb.listing.models.dtos.request.PropertyReviewRequest
import com.app.airbnb.listing.models.dtos.response.PropertyReviewResponse
import com.app.airbnb.listing.models.entities.PropertyReview
import com.app.airbnb.listing.models.mappers.PropertyReviewDTOEntityMapper
import com.app.airbnb.listing.services.PropertyReviewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/properties/{propertyId}/reviews")
class PropertyReviewController(
        @Autowired
        val propertyReviewService: PropertyReviewService
) {
    @PostMapping
    fun addReviewForAProperty(
            @PathVariable propertyId: String,
            @RequestBody propertyReviewRequest: PropertyReviewRequest
    ): ResponseEntity<PropertyReviewResponse> {
        val property = propertyReviewService.addReviewForAProperty(propertyId, propertyReviewRequest)
        return ResponseEntity(
                PropertyReviewDTOEntityMapper.toPropertyReviewResponse(property),
                HttpStatus.OK)
    }

    @GetMapping
    fun getReviewsForAProperty(@PathVariable propertyId: String): ResponseEntity<PropertyReviewResponse> {
        val property = propertyReviewService.getReviewsForAProperty(propertyId)
        return ResponseEntity(
                PropertyReviewDTOEntityMapper.toPropertyReviewResponse(property),
                HttpStatus.OK)
    }


    @PutMapping
    fun updateReviewForAProperty(
            @PathVariable propertyId: String,
            @RequestBody propertyReviewRequest: PropertyReviewRequest
    ): ResponseEntity<PropertyReview> {
        val propertyReview = propertyReviewService.updateReviewForAProperty(propertyReviewRequest)
        return ResponseEntity(
                propertyReview,
                HttpStatus.OK)
    }

    @GetMapping("/{reviewId}")
    fun deleteReviewForAProperty(
            @PathVariable propertyId: String,
            @PathVariable reviewId: String
    ) {

    }
}