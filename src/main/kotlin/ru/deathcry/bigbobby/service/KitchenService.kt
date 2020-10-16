package ru.deathcry.bigbobby.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.deathcry.bigbobby.dto.IngredientDto
import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.repository.IngredientRepository
import ru.deathcry.bigbobby.repository.MenuRepository
import ru.deathcry.bigbobby.util.morph


@Service
class KitchenService(
        var menuRepo: MenuRepository,
        var ingredientRepo: IngredientRepository
){

    fun listDishes(page: Int, pageSize: Int): List<MenuItemDto> {
        val paging: Pageable = PageRequest.of(page, pageSize)
        return menuRepo.findAll(paging).toList().map { MenuItemDto(it) }
    }

    fun searchDish(name: String): List<MenuItemDto> {
        return menuRepo.findAll().toList().map { MenuItemDto(it) }
    }

    fun addNewDish(dish: MenuItemDto){
        val dishEntity = dish.morph()
        menuRepo.save(dishEntity)
    }

    fun listIngredients(page: Int, pageSize: Int): List<IngredientDto> {
        val paging: Pageable = PageRequest.of(page, pageSize)
        return ingredientRepo.findAll(paging).toList().morph()
    }

}