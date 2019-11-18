package com.example.productostienda.products.application.services

import com.example.productostienda.products.domain.entities.Product

interface IProductService {

    fun getProducts() : List<Product>

    fun getProductById(id : Int) : Product

    fun getProductByCategory(category: String): List<Product>

    fun getProductByName(name: String) : List<Product>

    fun getProductByPopular(popular:Int): List<Product>

    fun getProductsByName(name:String) : List<Product>



}