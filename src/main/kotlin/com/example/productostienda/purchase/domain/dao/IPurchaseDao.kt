package com.example.productostienda.purchase.domain.dao

import com.example.productostienda.purchase.domain.entities.Purchase
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface IPurchaseDao: CrudRepository<Purchase, Int> {

    @Query("SELECT * FROM productos.purchase where user_id=?1 AND productos.purchase.created_at = (select MAX(created_at) from productos.purchase where user_id=?1)",nativeQuery = true)
    fun ultimoproducto(id:Int) : List<Purchase>
}