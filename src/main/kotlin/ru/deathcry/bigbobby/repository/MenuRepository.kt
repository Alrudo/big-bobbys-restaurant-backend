package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.MenuItemEntity

@Repository
interface MenuRepository: CrudRepository<MenuItemEntity, Long>