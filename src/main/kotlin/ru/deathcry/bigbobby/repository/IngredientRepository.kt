package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.IngredientEntity

@Repository
interface IngredientRepository: CrudRepository<IngredientEntity, Long>