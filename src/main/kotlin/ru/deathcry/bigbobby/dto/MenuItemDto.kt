package ru.deathcry.bigbobby.dto

import ru.deathcry.bigbobby.model.MenuItemEntity
import ru.deathcry.bigbobby.util.IMorphable
import ru.deathcry.bigbobby.util.morph

data class MenuItemDto(
        val name: String,
        val lang_key: String,
        val ingredients: List<IngredientDto>,
        val price: Double,
        val weight: Double,
        val keywords: List<String>
): IMorphable<MenuItemEntity>{
    constructor(e: MenuItemEntity): this(e.name, e.lang_key, e.ingredients.morph(), e.price, e.weight, e.keywords)

    override fun morph(): MenuItemEntity {
        return MenuItemEntity(this)
    }
}