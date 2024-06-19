package com.app.airbnb.listing.controllers

import com.app.airbnb.listing.models.dtos.request.PropertyReviewRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/properties/{propertyId}/reviews")
class PropertyReviewController {
    @PostMapping
    fun addReviewForAProperty(
            @PathVariable propertyId: String,
            @RequestBody propertyReviewRequest: PropertyReviewRequest
    ) {

    }

    @GetMapping
    fun getReviewsForAProperty(@PathVariable propertyId: String) {

    }


    @PutMapping
    fun updateReviewForAProperty(
            @PathVariable propertyId: String,
            @RequestBody propertyReviewRequest: PropertyReviewRequest
    ) {

    }

    @GetMapping("/{reviewId}")
    fun deleteReviewForAProperty(
            @PathVariable propertyId: String,
            @PathVariable reviewId: String
    ) {

    }
}