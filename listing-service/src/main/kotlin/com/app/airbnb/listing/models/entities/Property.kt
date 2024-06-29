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
        var title: String,
        var description: String,
        @JdbcTypeCode(SqlTypes.JSON)
        @Column(columnDefinition = "jsonb")
        var address: Address,
        @Enumerated(EnumType.STRING)
        val propertyType: PropertyType,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        var photos: List<PropertyPhoto>?,
        @Enumerated(EnumType.STRING)
        val amenities: List<AmenityType>,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        var propertyReviews: MutableList<PropertyReview>?,
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "property_id")
        var propertyPrice: List<PropertyPricing>?,
        var isActive: Boolean
)

