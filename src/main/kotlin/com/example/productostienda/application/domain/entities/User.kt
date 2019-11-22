package com.example.productostienda.application.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
data class User(
        @Id
        @GeneratedValue
        var id: Int?,
        @Column(unique = true)
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