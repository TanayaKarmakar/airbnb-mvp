package com.app.airbnb.listing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ListingServiceApplication

fun main(args: Array<String>) {
	runApplication<ListingServiceApplication>(*args)
}
