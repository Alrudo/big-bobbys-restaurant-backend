package ru.deathcry.bigbobby

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.model.IngredientEntity
import ru.deathcry.bigbobby.model.MenuItemEntity
import ru.deathcry.bigbobby.repository.CustomerRepository
import ru.deathcry.bigbobby.repository.IngredientRepository
import ru.deathcry.bigbobby.repository.MenuRepository


@DataJpaTest
class RepoTests {

	@Autowired
	lateinit var entityManager: TestEntityManager

	@Autowired
	lateinit var customerRepo: CustomerRepository
	@Autowired
	lateinit var ingRepo: IngredientRepository
	@Autowired
	lateinit var menuRepo: MenuRepository

	@Test
	fun testCustomerRepo() {
		val alex = entityManager.persist(
				CustomerEntity("alex@mail.ru", "123123123", "alex", "beerpongovich", "+37256565656")
		)
		val oleg = entityManager.persist(
				CustomerEntity("oleshka.pjureshka@gmail.com", "123123123", "oleg", "sidorov", "+37256999666")
		)
		entityManager.flush()

		val byId: CustomerEntity? = customerRepo.findById(1).get()
		val byLastname: CustomerEntity? = customerRepo.findByLastName(oleg.lastName).firstOrNull()
		val all: List<CustomerEntity> = customerRepo.findAll().toList()

		Assertions.assertEquals(alex.phone, byId?.phone)
		Assertions.assertEquals(oleg.email, byLastname?.email)
		Assertions.assertEquals(2, all.size)
	}

	@Test
	fun testMenuAndIngredientRepo(){
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
		ings.values.forEach {
			entityManager.persist(it)
		}

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
		meals.forEach {
			entityManager.persist(it)
		}
		entityManager.flush()

		Assertions.assertEquals(19, ings.size)
		Assertions.assertEquals(4, meals.size)

		Assertions.assertEquals("misc", ingRepo.findByName("Honey").type)
		Assertions.assertEquals(listOf("gluten"), ingRepo.findByName("Breadcrumbs").allergens)
		Assertions.assertEquals(4.5, menuRepo.findByName("Onion rings").price)
		Assertions.assertEquals(3, menuRepo.findByName("Steak with roasted potatoes").ingredients.size)

	}
}
