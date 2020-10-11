package ru.deathcry.bigbobby.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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

    @GetMapping("/")
    fun findAll(): List<MenuItemEntity> {
        return menuRepo.findAll().toList()
    }

    @GetMapping("/ingredient")
    fun findAllIngredients(): List<IngredientEntity> {
        return ingredientRepo.findAll().toList()
    }
       
    @GetMapping("/save")
    fun process(): String{
        ingredientRepo.save(IngredientEntity("Apple", "menu.ingredient.apple", "fruit"))
        ingredientRepo.save(IngredientEntity("Pineapple", "menu.ingredient.pineapple", "fruit"))
        ingredientRepo.save(IngredientEntity("Chicken cutlet", "menu.ingredient.chicken_cutlet", "meat"))
        val ingredient = ingredientRepo.save(IngredientEntity("Cabbage", "menu.ingredient.cabbage", "vegetable"))
        val ingredient2 = ingredientRepo.save(IngredientEntity("Water", "menu.ingredient.water", "none"))
        menuRepo.save(MenuItemEntity("Cabbage soup", "menu.ingredient.cabbage_soup", listOf(ingredient, ingredient2)))
        return "Done"
    }
}