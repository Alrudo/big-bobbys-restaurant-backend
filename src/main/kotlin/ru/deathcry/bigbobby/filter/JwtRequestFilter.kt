package ru.deathcry.bigbobby.filter

import io.jsonwebtoken.ExpiredJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.service.CustomerService
import ru.deathcry.bigbobby.util.JwtUtil
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
    private val customerService: CustomerService,
    private val jwtUtil: JwtUtil
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorizationHeader = request.getHeader("Authorization")
        var email: String? = null
        var jwt: String? = null
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7)
            email = try{
                jwtUtil.extractUsername(jwt)
            }catch (e: ExpiredJwtException){
                return chain.doFilter(request, response)
            }
        }
        if (email != null && SecurityContextHolder.getContext().authentication == null) {
            val customer: CustomerEntity = customerService.getUserByEmail(email)
            if (jwt != null && jwtUtil.validateToken(jwt, customer)) {
                val jwtToken = UsernamePasswordAuthenticationToken(
                    customer, null, customer.getAuthorities()
                )
                jwtToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = jwtToken
            }
        }
        chain.doFilter(request, response)
    }
}