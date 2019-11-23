package com.example.productostienda.purchase.domain.entities

import com.example.productostienda.application.domain.entities.User
import com.example.productostienda.products.domain.entities.Product
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "purchase")
data class Purchase(
        @Id
        @GeneratedValue
        var id: Int?,
        @NotNull
        var created_at: LocalDateTime = LocalDateTime.now(),
        var update_at: LocalDateTime?,
        //@JsonBackReference(value="user")
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        @JsonIgnoreProperties("purchase")
        var user: User?,
        //@JsonBackReference(value="products")
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        @JsonIgnoreProperties("purchase")
        var product: Product?
)




