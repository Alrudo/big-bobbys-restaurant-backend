package ru.deathcry.bigbobby.service

import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.codec.Hex
import org.springframework.stereotype.Service
import ru.deathcry.bigbobby.dto.RegistrationRequestDto
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.repository.CustomerRepository
import java.security.MessageDigest


@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    @Throws(UsernameNotFoundException::class)
    fun getUserByEmail(email: String): CustomerEntity {
        return customerRepository.findByEmail(email).firstOrNull()
            ?: throw UsernameNotFoundException("Customer with such email does not exist")
    }

    fun checkAuthCredentials(email: String, password: String): Boolean {
        return customerRepository.findByEmailAndPassword(email, password.sha256()).firstOrNull() != null
    }

    fun registerCustomer(regDto: RegistrationRequestDto): Boolean {
        if (customerRepository.findByEmail(regDto.email).isNotEmpty()) {
            throw Exception("Kasutaja sellise emailiga juba eksisteerib!")
        }
        customerRepository.save(
            CustomerEntity(
                regDto.email,
                regDto.password.sha256(),
                regDto.firstname
            )
        )

        return true
    }

    fun String.sha256(): String {
        val md: MessageDigest = MessageDigest.getInstance("SHA-256")
        md.update(toByteArray())
        val digest: ByteArray = md.digest()
        return String(Hex.encode(digest))
    }
}