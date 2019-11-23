package com.example.productostienda.products.application.services

import com.example.productostienda.products.domain.entities.Product
import org.springframework.data.domain.Page

interface IProductService {

    fun getAllProducts(page:Int) : Page<Product>

    fun getProductById(id : Int) : Product

    fun getProductsByCategory(category: String, page:Int) : Page<Product>

    fun getProductsByName(name:String, page:Int) : Page<Product>

}