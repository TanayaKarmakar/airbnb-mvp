package com.app.airbnb.listing.models.entities

import com.app.airbnb.listing.models.enums.AmenityType
import com.app.airbnb.listing.models.enums.PropertyType
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
class Property(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String,
        val title: String,
        val description: String,
        //@OneToOne
        @JdbcTypeCode(SqlTypes.JSON)
        @Column(columnDefinition = "jsonb")
        val address: Address,
        @Enumerated(EnumType.STRING)
        val propertyType: PropertyType,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        val photos: List<PropertyPhoto>?,
        @Enumerated(EnumType.STRING)
        val amenities: List<AmenityType>,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        val propertyReviews: List<PropertyReview>?,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        val propertyPrice: List<PropertyPricing>?,
        val isActive: Boolean
)

