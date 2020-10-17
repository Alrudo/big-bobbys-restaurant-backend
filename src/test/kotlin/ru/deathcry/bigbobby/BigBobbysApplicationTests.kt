package ru.deathcry.bigbobby

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.repository.CustomerRepository


@DataJpaTest
class BigBobbysApplicationTest {

	@Autowired
	lateinit var entityManager: TestEntityManager

	@Autowired
	lateinit var customerRepo: CustomerRepository

	@Test
	fun testCustomerRepo() {
		val alex = entityManager.persist(
				CustomerEntity("alex@mail.ru", "123123123", "alex", "beerpongovich", "+37256565656")
		)
		val oleg = entityManager.persist(
				CustomerEntity("oleshka.pjureshka@gmail.com", "123123123", "oleg", "sidorov", "+37256999666")
		)
		entityManager.flush()

		val found: CustomerEntity? = customerRepo.findByLastName(oleg.lastName).firstOrNull()
		val all: List<CustomerEntity> = customerRepo.findAll().toList()

		Assertions.assertEquals(found?.email, oleg.lastName)
		Assertions.assertEquals(all.size, 2)
	}

}
