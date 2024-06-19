package com.app.airbnb.listing.controllers

import com.app.airbnb.listing.models.dtos.request.PropertyCreationRequest
import com.app.airbnb.listing.models.dtos.response.PropertyResponse
import com.app.airbnb.listing.models.mappers.PropertyDTOEntityMapper
import com.app.airbnb.listing.services.PropertyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/properties")
class PropertyController(
        @Autowired
        private val propertyService: PropertyService
) {
    @GetMapping("/{propertyId}")
    fun getPropertyById(
            @PathVariable propertyId: String
    ): ResponseEntity<PropertyResponse>? {
        val property =  propertyService.getPropertyById(propertyId)
        return ResponseEntity(PropertyDTOEntityMapper.toPropertyResponseDTO(property),
                HttpStatus.OK)
    }

    @PostMapping
    fun addProperty(
            @RequestBody propertyRequest: PropertyCreationRequest
    ): ResponseEntity<PropertyResponse>? {
        val property = propertyService.addProperty(propertyRequest)
        return ResponseEntity(PropertyDTOEntityMapper.toPropertyResponseDTO(property),
                HttpStatus.CREATED)
    }

    @PutMapping
    fun updateProperty(): ResponseEntity<PropertyResponse>? {
        return null
    }

    @DeleteMapping
    fun deleteProperty(
            @PathVariable propertyId: String
    ): ResponseEntity<PropertyResponse>? {
        return null
    }
}