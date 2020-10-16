package ru.deathcry.bigbobby.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.deathcry.bigbobby.dto.IngredientDto
import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.service.KitchenService

@RestController
@RequestMapping("/menu")
class MenuController(
        var kitchen: KitchenService
) {

    @GetMapping
    fun listDishes(
            @RequestParam(defaultValue = "0") page: Int,
            @RequestParam(defaultValue = "12") pageSize: Int
    ): List<MenuItemDto> {
        return kitchen.listDishes(page, pageSize)
    }

    @GetMapping("/ingredient")
    fun listIngredients(
            @RequestParam(defaultValue = "0") page: Int,
            @RequestParam(defaultValue = "12") pageSize: Int
    ): List<IngredientDto> {
        return kitchen.listIngredients(page, pageSize)
    }
}