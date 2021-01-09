package ru.deathcry.bigbobby

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.model.MenuItemEntity
import ru.deathcry.bigbobby.repository.*
import ru.deathcry.bigbobby.service.KitchenService


@SpringBootTest
class KitchenServiceTest {
    @Mock
    lateinit var menu: MenuRepository

    @Mock
    lateinit var orders: OrderRepository

    @Mock
    lateinit var ingredients: IngredientRepository

    @Mock
    lateinit var customers: CustomerRepository

    @InjectMocks
    lateinit var kitchen: KitchenService

    val ings = listOf(
            IngredientEntity("Beef", "ingredient.meat.beef", "meat"),
            IngredientEntity("Potato", "ingredient.vegetable.potato", "vegetable"),
            IngredientEntity("Wine sauce", "ingredient.misc.wine_sauce", "misc")
    ).map { it.name to it }.toMap()

    val steak = MenuItemEntity("Steak with roasted potatoes", "meals.salads.steak_n_potatoes", listOf(
            "Beef", "Wine sauce", "Potato"
    ).mapNotNull { ings[it] }, 13.5, 0.3)

    @Test
    fun testDishSearch() {
        Mockito.`when`(menu.findByName("Steak with roasted potatoes")).thenReturn(steak)

        val meal = kitchen.searchDish("Steak with roasted potatoes")
        Assertions.assertEquals("Beef", meal.ingredients.first().name)
    }

    @Mock
    lateinit var mealPage: Page<MenuItemEntity>

    @Test
    fun testDishList() {
        val paging: Pageable = PageRequest.of(0, 12)
        Mockito.`when`(menu.findAll(paging)).thenReturn(mealPage)
        Mockito.`when`(mealPage.toList()).thenReturn(listOf(steak))

        val meal = kitchen.listDishes(0, 12).first()
        Assertions.assertEquals("Beef", meal.ingredients.first().name)
    }

}