package ru.deathcry.bigbobby.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.web.bind.annotation.*
import ru.deathcry.bigbobby.dto.AuthenticationResponseDto
import ru.deathcry.bigbobby.dto.ErrorMessageDto
import ru.deathcry.bigbobby.dto.RegistrationRequestDto
import ru.deathcry.bigbobby.dto.SuccessMessageDto
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.service.CustomerService
import ru.deathcry.bigbobby.util.JwtUtil
import java.nio.charset.StandardCharsets
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/")
class AuthController(
    private val jwtTokenUtil: JwtUtil,
    private val customerService: CustomerService
) {
    @RequestMapping("/hello")
    fun firstPage(authentication: Authentication): String {
        val userDetails = authentication.principal as CustomerEntity
        if(!userDetails.getAuthorities().contains(SimpleGrantedAuthority("USER"))){
            throw Exception("Not enough permissions")
        }
        return "Hello World"
    }

    @PostMapping("/auth", produces = ["application/json"])
    fun createAuthenticationToken(@RequestHeader("Authorization") authorization: String): ResponseEntity<*>? {
        if (!authorization.toLowerCase().startsWith("basic")) {
            return ResponseEntity.badRequest().body("""{"error": true, "message": "Incorrect authorization header"}""")
        }

        val base64Credentials: String = authorization.substring("Basic".length).trim()
        val credDecoded: ByteArray = Base64.getDecoder().decode(base64Credentials)
        val credentials = String(credDecoded, StandardCharsets.UTF_8)
        val values = credentials.split(":", limit = 2)

        val userDetails: CustomerEntity
        try {
            if(!customerService.checkAuthCredentials(values[0], values[1])){
                throw Exception("Vale email või password")
            }
            userDetails = customerService.getUserByEmail(values[0])
        } catch (e: Exception) {
            return ErrorMessageDto(e.message?:"Unknown").response(400)
        }
        val jwt: String = jwtTokenUtil.generateToken(userDetails)
        return ResponseEntity.ok<Any>(AuthenticationResponseDto(jwt))
    }

    @PostMapping("/register")
    fun createNewUser(@Valid @RequestBody regDto: RegistrationRequestDto): ResponseEntity<*>? {
        try{
            customerService.registerCustomer(regDto)
        }catch (e: Exception){
            return ErrorMessageDto(e.message?:"Unknown").response(400)
        }
        return SuccessMessageDto("Kasutaja oli edukalt loodud").response()
    }
       
}