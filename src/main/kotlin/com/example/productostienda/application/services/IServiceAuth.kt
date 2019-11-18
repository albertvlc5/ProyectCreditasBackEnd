package com.example.productostienda.application.services

import javax.servlet.http.HttpServletRequest


interface IServiceAuth {
    fun getJWT(username:String, request:HttpServletRequest ):String
}