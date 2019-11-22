package com.example.productostienda.products.domain.dao

import com.example.productostienda.products.domain.entities.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface IProductDao : CrudRepository<Product, Int> {
    fun getProductById(id: Int) : Product
    fun findByCategory(category:String): List<Product>
    fun getProductByName(name : String) : List<Product>
    //fun findByPopular(popular: Int) : List<Product>

    @Query("SELECT * FROM productos.products where category LIKE ?1 and id!=?2",nativeQuery = true)
    fun findRelatedItems(category: String, id:Int) : List<Product>

    @Query("SELECT * FROM productos.products WHERE productos.products.id =?1 ", nativeQuery = true)
    fun findCategoria(id:Int) : List<Product>

    @Query("SELECT * FROM productos.products WHERE productos.products.popular=1 ", nativeQuery = true)
    fun findPopular() : List<Product>

}