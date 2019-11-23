package com.example.productostienda.products.application.services.implementation

import com.example.productostienda.products.domain.dao.IProductDao
import com.example.productostienda.products.domain.entities.Product
import com.example.productostienda.products.application.services.IProductService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : IProductService {

    private var Logger = LogFactory.getLog("DoctorController.class")

    @Autowired
    private lateinit var productDao: IProductDao

    override fun getAllProducts(page: Int): Page<Product> {
        val pages: Pageable = PageRequest.of(page, 12)
        return productDao.findAll(pages)
    }

    override fun getProductById(id: Int): Product = productDao.getProductById(id)

    override fun getProductsByName(name: String, page: Int): Page<Product> {
        val pages: Pageable = PageRequest.of(page, 5)
        return productDao.findAllByNameContains(name, pages)
    }

    override fun getProductsByCategory(category: String, page: Int): Page<Product> {
        val pages: Pageable = PageRequest.of(page, 5)
        return productDao.findAllByCategory(category, pages)
    }

}