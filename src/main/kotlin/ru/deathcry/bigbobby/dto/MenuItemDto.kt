package ru.deathcry.bigbobby.dto

import ru.deathcry.bigbobby.model.MenuItemEntity

data class MenuItemDto(
        val name: String,
        val lang_key: String,
        val ingredients: List<IngredientDto>,
        val price: Double,
        val weight: Double,
        val keywords: List<String>
){
    constructor(e: MenuItemEntity): this(e.name, e.lang_key, e.ingredients.map { IngredientDto(it) }, e.price, e.weight, e.keywords)
}