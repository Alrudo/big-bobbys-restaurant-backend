package ru.deathcry.bigbobby.service

import org.springframework.security.crypto.codec.Hex
import org.springframework.stereotype.Service
import java.security.MessageDigest


@Service
class CustomerService {

    fun sha256(original: String): String? {
        val md: MessageDigest = MessageDigest.getInstance("SHA-256")
        md.update(original.toByteArray())
        val digest: ByteArray = md.digest()
        return String(Hex.encode(digest))
    }

}