package ru.deathcry.bigbobby.dto

import java.io.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class RegistrationRequestDto(
    @get:NotBlank @get:Email val email: String = "",
    @get:NotBlank @get:Size(min = 6) val password: String = "",
    @get:NotBlank @get:Size(min = 4, max = 20) val firstname: String = ""
) : Serializable