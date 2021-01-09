package ru.deathcry.bigbobby.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.model.CustomerEntity
import ru.deathcry.bigbobby.service.KitchenService
import ru.deathcry.bigbobby.util.morph

@RestController
@RequestMapping("/common")
class CommonController(
        var kitchen: KitchenService
) {

    @GetMapping("/testdata")
    fun addTestData(): List<MenuItemDto> {
        return kitchen.addTestData().morph()
    }

    @GetMapping("/ping")
    fun ping(authentication: Authentication): String {
        val userDetails = authentication.principal as CustomerEntity
        return "OK + " + userDetails.getAuthorities()
    }
       
}