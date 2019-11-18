package com.example.productostienda.products.domain.dao

import com.example.productostienda.products.domain.entities.Product
import org.springframework.data.repository.CrudRepository


interface IProductDao : CrudRepository<Product, Int> {
    fun getProductById(id: Int) : Product
    fun findByCategory(category:String): List<Product>
    fun getProductByName(name : String) : List<Product>
    fun findByPopular(popular: Int) :List<Product>

}