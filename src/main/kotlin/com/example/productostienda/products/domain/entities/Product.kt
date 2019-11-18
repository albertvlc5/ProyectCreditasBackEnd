package com.example.productostienda.products.domain.entities

import com.example.productostienda.purchase.domain.entities.Purchase
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="products")
data class Product (
        @Id
        @GeneratedValue
        var id : Int?,
        var name:String?,
        var category: String?,
        var price: Float?,
        @Column(columnDefinition = "TEXT")
        var description: String?,
        var popular: Int?,
        var image: String?,
        @NotNull
        var created_at: LocalDateTime? = LocalDateTime.now(),
        var update_at: LocalDateTime?,
        // @JsonBackReference("products")
        @JsonManagedReference
        @OneToMany(mappedBy="product",cascade = [(CascadeType.ALL)],fetch= FetchType.EAGER)
        @JsonIgnoreProperties("purchase")
        var purchase: List<Purchase>?

)
