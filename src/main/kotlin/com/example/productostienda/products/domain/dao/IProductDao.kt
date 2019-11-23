package com.example.productostienda.products.domain.dao

import com.example.productostienda.products.domain.entities.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository


interface IProductDao : PagingAndSortingRepository<Product, Int>  {
    fun getProductById(id: Int) : Product
    fun findAllByCategory(category:String,pageable: Pageable):Page<Product>
    fun findAllByNameContains(name:String, pageable: Pageable) : Page<Product>

    @Query("SELECT * FROM productos.products where category LIKE ?1 and id!=?2",nativeQuery = true)
    fun findRelatedItems(category: String, id:Int) : List<Product>

    @Query("SELECT * FROM productos.products WHERE productos.products.id =?1 ", nativeQuery = true)
    fun findCategoria(id:Int) : List<Product>

    @Query("SELECT * FROM productos.products WHERE productos.products.popular=1", nativeQuery = true)
    fun findPopular(pageable: Pageable) : Page<Product>

}