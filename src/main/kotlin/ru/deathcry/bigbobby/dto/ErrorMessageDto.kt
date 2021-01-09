package ru.deathcry.bigbobby.dto

import org.springframework.http.ResponseEntity
import java.io.Serializable

data class ErrorMessageDto(val message: String?): Serializable{
    val error: Boolean = true

    fun response(code: Int): ResponseEntity<ErrorMessageDto> {
        return ResponseEntity.status(code).body(this)
    }
}