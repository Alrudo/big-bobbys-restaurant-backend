package ru.deathcry.bigbobby.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.model.MenuItemEntity
import ru.deathcry.bigbobby.repository.IngredientRepository
import ru.deathcry.bigbobby.repository.MenuRepository

@RestController
@RequestMapping("/menu")
class MenuController(
        var menuRepo: MenuRepository,
        var ingredientRepo: IngredientRepository
) {

    @GetMapping
    fun findAll(): List<MenuItemDto> {
        return menuRepo.findAll().toList().map { MenuItemDto(it) }
    }

    @GetMapping("/ingredient")
    fun findAllIngredients(): List<IngredientEntity> {
        return ingredientRepo.findAll().toList()
    }
}