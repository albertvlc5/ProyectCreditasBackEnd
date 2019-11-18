package com.example.productostienda.purchase.application.services.implementation


import com.example.productostienda.purchase.application.services.IPurchaseService
import com.example.productostienda.purchase.domain.dao.IPurchaseDao
import com.example.productostienda.purchase.domain.entities.Purchase
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IPurchaseImpl : IPurchaseService {

    @Autowired
    private lateinit var  purchaseDao: IPurchaseDao

    private var Logger = LogFactory.getLog("PurchaseServiceImpl.class")

    override fun addPurchase(purchase: Purchase) : Purchase {
        Logger.warn(purchase)
        return purchaseDao.save(purchase)
    }
    @Transactional(readOnly=true)
    override fun getPurchase(): List<Purchase> = purchaseDao.findAll() as List<Purchase>


}