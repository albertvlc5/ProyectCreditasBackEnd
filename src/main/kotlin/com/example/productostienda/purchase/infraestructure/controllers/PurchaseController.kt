package com.example.productostienda.purchase.infraestructure.controllers

import com.example.productostienda.purchase.application.services.IPurchaseService
import com.example.productostienda.purchase.domain.dao.IPurchaseDao
import com.example.productostienda.purchase.domain.entities.Purchase
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("api/v1/purchase")
class PurchaseController {

    private var Logger = LogFactory.getLog("PurchaseController.class")

    @Autowired
    lateinit var purchaseService:IPurchaseService

    @Autowired
    lateinit var  purchaseSql:IPurchaseDao

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/")
    fun purchase(@RequestBody purchase: Purchase, request: HttpServletRequest): ResponseEntity<Purchase>
    {
        var result: Purchase= purchaseService.addPurchase(purchase)
        return when(result) {
            null ->  ResponseEntity(result, HttpStatus.BAD_REQUEST)
            else -> ResponseEntity(result, HttpStatus.CREATED)
        }

    }
    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/getall","GET","application/json")
    fun getPurchase():ResponseEntity<List<Purchase>> = ResponseEntity(purchaseService.getPurchase(), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/lastpurchase/{id}")
    fun getLast(@PathVariable id: Int):ResponseEntity<List<Purchase>> = ResponseEntity(purchaseSql.ultimoproducto(id), HttpStatus.OK)

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/getall/{id}","GET","application/json")
    fun getAllPurchasesByID(@PathVariable id: Int):ResponseEntity<List<Purchase>> = ResponseEntity(purchaseSql.getAllPurchasesById(id), HttpStatus.OK)

}