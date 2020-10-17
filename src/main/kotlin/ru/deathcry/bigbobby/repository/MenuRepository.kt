package ru.deathcry.bigbobby.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.deathcry.bigbobby.model.MenuItemEntity

@Repository
interface MenuRepository: PagingAndSortingRepository<MenuItemEntity, Long>{
    fun findByName(name: String): MenuItemEntity
}