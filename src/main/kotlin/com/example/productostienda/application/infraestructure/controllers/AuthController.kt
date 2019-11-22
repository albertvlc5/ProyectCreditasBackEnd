package com.example.productostienda.application.infraestructure.controllers

import com.example.productostienda.application.domain.dao.IUserDao
import com.example.productostienda.application.domain.entities.User
import com.example.productostienda.application.services.IServiceAuth
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("api/v1")
class AuthController {
    private var Logger = LogFactory.getLog("AuthController.class")

    @Autowired
    lateinit var serviceJWT: IServiceAuth
    @Autowired
    lateinit var userDao: IUserDao
    @Autowired
    private lateinit var userService:IServiceAuth

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/auth")
    fun login(@RequestBody user: User, request:HttpServletRequest): ResponseEntity<Any>
    {
        Logger.warn("Entra login")
        var result = userDao.findByUsername(user.username!!)
        if(!result.isPresent) return ResponseEntity("Datos Incorrecto",HttpStatus.NOT_FOUND)
        if(!user.password.equals(result.get().password)) return ResponseEntity("Datos Incorrecto", HttpStatus.NOT_FOUND)
        Logger.warn(result)
        var token:String = serviceJWT.getJWT(result.get().username as String, request)
        Logger.warn("token ->"+token);
        return ResponseEntity(token,HttpStatus.OK)

    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/id")
    fun id(@RequestBody user: User, request:HttpServletRequest): ResponseEntity<Any>
    {
        var result = userDao.findByUsername(user.username!!)
        var userid =result.get().id as Int
        return ResponseEntity(userid ,HttpStatus.OK)

    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/register")
    fun addDoctor(@RequestBody user:User):ResponseEntity<Unit>{
        try {
            Logger.warn("User creado")
            userService.addUser(user)
            return ResponseEntity(HttpStatus.CREATED)
        }catch(e:Exception){
            Logger.error(e.message)
            return ResponseEntity(HttpStatus.BAD_GATEWAY)
        }
    }

    


}