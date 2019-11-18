package com.example.productostienda.purchase.application.services


import com.example.productostienda.purchase.domain.entities.Purchase

interface IPurchaseService {
    fun addPurchase(purchase:Purchase) : Purchase
    fun getPurchase() : List<Purchase>


}