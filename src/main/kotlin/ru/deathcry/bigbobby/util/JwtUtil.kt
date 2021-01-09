package ru.deathcry.bigbobby.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap

@Service
class JwtUtil {
    private val SECRET_KEY = "tFNWfcciv9SdV5nWOD4DfwmoqOwumoRDjHePxATwY1OdiUwQ5dBbDOTEOXH2UcCg"

    fun extractUsername(token: String): String? {
        return extractClaim(token, Function { obj: Claims -> obj.subject })
    }
    fun extractAuthorities(token: String): List<String> {
        return extractClaim(token, Function { obj: Claims -> obj["scope"] as List<*> }).map { it.toString() }
    }

    fun extractExpiration(token: String): Date? {
        return extractClaim(token, Function { obj: Claims -> obj.expiration })
    }

    fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T {
        val claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }

    private fun extractAllClaims(token: String?): Claims {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token)?.before(Date()) == true
    }

    fun generateToken(userDetails: UserDetails): String {
        val claims: HashMap<String, Any> = HashMap()
        claims["scope"] = userDetails.authorities.map { it.authority }
        return createToken(claims, userDetails.username)
    }

    private fun createToken(claims: Map<String, Any>, subject: String): String {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 30))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }
}