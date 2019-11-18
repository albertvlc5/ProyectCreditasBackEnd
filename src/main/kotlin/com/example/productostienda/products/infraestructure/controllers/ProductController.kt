package com.example.productostienda.products.infraestructure.controllers

import com.example.productostienda.products.domain.entities.Product
import com.example.productostienda.products.application.services.IProductService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/productos")
class ProductController {

    @Autowired
    private lateinit var productService: IProductService

    private var Logger = LogFactory.getLog("DoctorController.class")

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/", "GET", "application/json")
    fun getProducts(): ResponseEntity<List<Product>> = ResponseEntity(productService.getProducts(), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/category/{category}")
    fun findByCategory(@PathVariable category: String): List<Product> {
        val result: List<Product> = productService.getProductByCategory(category)
        return result
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/details/{id}")
    fun getProductById(@PathVariable id: Int): Product {
        val result: Product = productService.getProductById(id)
        return result
    }

    /*@CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/{name}")
    fun getProductByName(@PathVariable name: String): List<Product> {
        val result: List<Product> = productService.getProductByName(name)
        return result
    }*/

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/popular")
    fun getProductByPopular(): List<Product> {
        val result: List<Product> = productService.getProductByPopular(1)
        Logger.warn(result)
        return result
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/nombre")
    fun getProductsByName(@RequestBody products: Product): ResponseEntity <List<Product>> {
        val result = productService.getProductsByName(products.name!!)
        return ResponseEntity(result,HttpStatus.OK)
    }



}