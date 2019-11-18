package com.example.productostienda.application.domain.entities


import com.example.productostienda.purchase.domain.entities.Purchase
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.sun.istack.NotNull
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
data class User(
        @Id
        @GeneratedValue
        var id: Int?,
        var username: String?,
        var password: String?,
        @NotNull
        var created_at: LocalDateTime = LocalDateTime.now(),
        var update_at: LocalDateTime?
       /* @JsonManagedReference("purchase")
        @OneToMany(mappedBy="user",cascade = [(CascadeType.ALL)],fetch= FetchType.EAGER)
        @JsonIgnoreProperties("user")
        var purchase: List<Purchase>?*/
) {
}