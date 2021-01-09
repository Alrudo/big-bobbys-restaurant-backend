package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.CustomerEntity

@Repository
interface CustomerRepository: CrudRepository<CustomerEntity, Long> {
    fun findByEmail(email: String): List<CustomerEntity>
    fun findByEmailAndPassword(email: String, password: String): List<CustomerEntity>
    fun findByLastName(lastName: String): List<CustomerEntity>
}