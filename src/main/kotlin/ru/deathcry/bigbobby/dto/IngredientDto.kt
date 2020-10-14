package ru.deathcry.bigbobby.dto

import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.model.converter.StringListConverter
import javax.persistence.*

data class IngredientDto(
    val name: String = "",
    val lang_key: String = "",
    val type: String = "",
    val allergens: List<String> = listOf()
) {
    constructor(e: IngredientEntity): this(e.name, e.lang_key, e.type, e.allergens)
}