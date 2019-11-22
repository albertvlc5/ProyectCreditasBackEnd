package com.example.productostienda.products.application.services.implementation

import com.example.productostienda.products.domain.dao.IProductDao
import com.example.productostienda.products.domain.entities.Product
import com.example.productostienda.products.application.services.IProductService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl : IProductService {

    private var Logger = LogFactory.getLog("DoctorController.class")

    @Autowired
    private lateinit var productDao: IProductDao

    override fun getProducts(): List<Product> = productDao.findAll() as List<Product>

    override fun getProductByCategory(category: String): List<Product> =productDao.findByCategory(category)

    override fun getProductById(id: Int): Product = productDao.getProductById(id)

    override fun getProductByName(name: String): List<Product> = productDao.getProductByName(name)

   /* override fun getProductByPopular(popular: Int): List<Product> {
        Logger.warn(popular.toString())
        val result = productDao.findByPopular(popular)
        Logger.warn(result)
       return result
    }*/

    override fun getProductsByName(name: String): List<Product> {
        var result =productDao.findAll();
        result=result.filter{it.name!!.contains(name)}
        return result
    }


}