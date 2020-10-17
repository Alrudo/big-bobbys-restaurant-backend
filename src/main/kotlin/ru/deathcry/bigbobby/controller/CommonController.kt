package ru.deathcry.bigbobby.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.deathcry.bigbobby.dto.MenuItemDto
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
       
}