package ru.deathcry.bigbobby.dto

import org.springframework.http.ResponseEntity
import java.io.Serializable

data class SuccessMessageDto(val message: String?): Serializable{

    fun response(): ResponseEntity<SuccessMessageDto> {
        return ResponseEntity.ok(this)
    }
}