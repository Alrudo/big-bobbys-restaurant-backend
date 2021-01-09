package ru.deathcry.bigbobby.util

import org.springframework.security.core.authority.SimpleGrantedAuthority

object Authorities {
    val USER = SimpleGrantedAuthority("USER")
    val ADMIN = SimpleGrantedAuthority("ADMIN") // Not implemented yet
}