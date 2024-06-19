package com.app.airbnb.listing.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/properties/price")
class PropertyPriceController {
    @PostMapping
    fun addPrice() {

    }

    @PutMapping
    fun updatePrice() {

    }
}