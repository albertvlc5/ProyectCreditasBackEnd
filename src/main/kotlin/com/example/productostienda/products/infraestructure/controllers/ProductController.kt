package com.example.productostienda.products.infraestructure.controllers

import com.example.productostienda.products.domain.entities.Product
import com.example.productostienda.products.application.services.IProductService
import com.example.productostienda.products.domain.dao.IProductDao
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/productos")
class ProductController {

    @Autowired
    private lateinit var productService: IProductService

    @Autowired
    lateinit var productSql: IProductDao

    private var Logger = LogFactory.getLog("DoctorController.class")

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/details/{id}")
    fun getProductById(@PathVariable id: Int): Product {
        val result: Product = productService.getProductById(id)
        return result
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/")
    fun getAllProducts(@RequestParam(defaultValue = "0") page: Int): ResponseEntity<Page<Product>> = ResponseEntity(productService.getAllProducts(page), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/popular")
    fun getProductByPopular(@RequestParam(defaultValue = "0") page: Int): ResponseEntity<Page<Product>> {
        val pages: Pageable = PageRequest.of(page, 5)
        val result = productSql.findPopular(pages)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/nombre/{name}")
    fun getProductsByName(@PathVariable name: String, @RequestParam(defaultValue = "0") page: Int): ResponseEntity<Page<Product>> {
        val result = productService.getProductsByName(name, page)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/category/{category}")
    fun getProductsByCategory(@PathVariable category: String, @RequestParam(defaultValue = "0") page: Int): ResponseEntity<Page<Product>> {
        val result = productService.getProductsByCategory(category, page)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/related/{category}/{id}")
    fun findRelatedItems(@PathVariable category: String, @PathVariable id: Int): ResponseEntity<List<Product>> = ResponseEntity(productSql.findRelatedItems(category, id), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/categoria/{id}")
    fun findCategoria(@PathVariable id: Int): ResponseEntity<List<Product>> = ResponseEntity(productSql.findCategoria(id), HttpStatus.OK)


}