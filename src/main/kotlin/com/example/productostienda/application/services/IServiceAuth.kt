package com.example.productostienda.application.services

import com.example.productostienda.application.domain.entities.User
import javax.servlet.http.HttpServletRequest


interface IServiceAuth {
    fun getJWT(username: String, request: HttpServletRequest): String

    fun addUser(user: User): User
}