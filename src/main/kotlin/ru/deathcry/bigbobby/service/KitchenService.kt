package ru.deathcry.bigbobby.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.deathcry.bigbobby.dto.IngredientDto
import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.model.MenuItemEntity
import ru.deathcry.bigbobby.model.OrderEntity
import ru.deathcry.bigbobby.repository.CustomerRepository
import ru.deathcry.bigbobby.repository.IngredientRepository
import ru.deathcry.bigbobby.repository.MenuRepository
import ru.deathcry.bigbobby.repository.OrderRepository
import ru.deathcry.bigbobby.util.morph


@Service
class KitchenService(
        var menuRepo: MenuRepository,
        var orderRepo: OrderRepository,
        var customerRepo: CustomerRepository,
        var ingredientRepo: IngredientRepository
) {

    fun listDishes(page: Int, pageSize: Int): List<MenuItemDto> {
        val paging: Pageable = PageRequest.of(page, pageSize)
        return menuRepo.findAll(paging).toList().map { MenuItemDto(it) }
    }

    fun searchDish(name: String): MenuItemDto {
        return menuRepo.findByName(name).morph()
    }

    fun addNewDish(dish: MenuItemDto) {
        val dishEntity = dish.morph()
        menuRepo.save(dishEntity)
    }

    fun listIngredients(page: Int, pageSize: Int): List<IngredientDto> {
        val paging: Pageable = PageRequest.of(page, pageSize)
        return ingredientRepo.findAll(paging).toList().morph()
    }

    fun addTestData(): List<MenuItemEntity> {
        orderRepo.deleteAll()
        customerRepo.deleteAll()
        menuRepo.deleteAll()
        ingredientRepo.deleteAll()

        val customer1 = customerRepo.save(CustomerEntity("sergei.saal15@gmail.com", "123123123", "Sergei", "Saal", ""))
        val customer2 = customerRepo.save(CustomerEntity("xsergeix123@yandex.ru", "123123123", "Sergei", "Saal", ""))
        val ings = listOf(
                IngredientEntity("Beef", "ingredient.meat.beef", "meat"),
                IngredientEntity("Chicken", "ingredient.meat.chicken", "meat"),
                IngredientEntity("Garlic", "ingredient.meat.chicken", "meat"),
                IngredientEntity("Wheat flour", "ingredient.grain.wheat_flour", "grain", listOf("gluten")),
                IngredientEntity("Milk", "ingredient.dairy.milk", "dairy", listOf("lactose")),
                IngredientEntity("Parmesan cheese", "ingredient.dairy.parmesan_cheese", "dairy", listOf("lactose")),
                IngredientEntity("Potato", "ingredient.vegetable.potato", "vegetable"),
                IngredientEntity("Garlic", "ingredient.vegetable.garlic", "vegetable"),
                IngredientEntity("Onion", "ingredient.vegetable.onion", "vegetable"),
                IngredientEntity("Tomato", "ingredient.vegetable.tomato", "vegetable"),
                IngredientEntity("Cherry tomato", "ingredient.vegetable.cherry_tomato", "vegetable"),
                IngredientEntity("Paprika", "ingredient.vegetable.paprika", "vegetable"),
                IngredientEntity("Romaine salad", "ingredient.vegetable.romaine_salad", "vegetable"),
                IngredientEntity("Wheat pasta", "ingredient.misc.wheat_pasta", "misc", listOf("gluten")),
                IngredientEntity("Breadcrumbs", "ingredient.misc.breadcrumbs", "misc", listOf("gluten")),
                IngredientEntity("Egg", "ingredient.misc.egg", "misc"),
                IngredientEntity("Honey", "ingredient.misc.honey", "misc"),
                IngredientEntity("Soy sauce", "ingredient.misc.soy_sauce", "misc"),
                IngredientEntity("Wine sauce", "ingredient.misc.wine_sauce", "misc"),
                IngredientEntity("Caesar sauce", "ingredient.misc.caesar_sauce", "misc")
        ).map { it.name to it }.toMap()
        ingredientRepo.saveAll(ings.values)
        val meals = listOf(
                MenuItemEntity("Honey chicken", "meals.chicken_meals.honey_chicken", listOf(
                        "Chicken", "Garlic", "Honey", "Tomato", "Soy sauce"
                ).mapNotNull { ings[it] }, 7.0, 0.2),
                MenuItemEntity("Onion rings", "meals.snacks.onion_rings", listOf(
                        "Onion", "Egg", "Wheat flour"
                ).mapNotNull { ings[it] }, 4.5, 0.15),
                MenuItemEntity("Caesar salad", "meals.salads.caesar", listOf(
                        "Chicken", "Cherry tomato", "Breadcrumbs", "Parmesan cheese", "Caesar sauce", "Romaine salad"
                ).mapNotNull { ings[it] }, 6.5, 0.25),
                MenuItemEntity("Steak with roasted potatoes", "meals.salads.steak_n_potatoes", listOf(
                        "Beef", "Wine sauce", "Potato"
                ).mapNotNull { ings[it] }, 13.5, 0.3)
        )
        menuRepo.saveAll(meals)
        orderRepo.save(OrderEntity("Sergei", "+37256666669", customer1))
        orderRepo.save(OrderEntity("Vasja", "+37256789451", customer1))
        return meals
    }
}
