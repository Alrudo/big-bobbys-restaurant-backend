package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.CustomerEntity

@Repository
interface CustomerRepository: CrudRepository<CustomerEntity, Long> {
    fun findByLastName(lastName: String): List<CustomerEntity>
} 