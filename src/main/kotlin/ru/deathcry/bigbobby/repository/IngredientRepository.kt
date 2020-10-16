package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.IngredientEntity

@Repository
interface IngredientRepository : PagingAndSortingRepository<IngredientEntity, Long>