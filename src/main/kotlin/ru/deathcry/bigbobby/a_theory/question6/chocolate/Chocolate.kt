package ru.deathcry.bigbobby.a_theory.question6.chocolate

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("cakes")
class Chocolate {
    //todo for question 6 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite
    //todo create a working api for an cafe specializing in cakes
    // It compiles and runs. You need to use proper annotations, methods, etc, however to ease the process you can use empty methods (examples below).
    // Follow the story to have only the necessary methods in it
    //todo 1
    // Welcome-welcome!
    // My name is Lukas and I am very happy to meet you.
    // Thank you for coming to Vienna, Austria.
    // Vienna is the best place for coffee. And my cafe, Chocolate, is the best cafe for cakes.
    // You should try my Sachertorte, oh-ah, es isst so gut.
    // No-no, stop thinking we have no time for cake, now we must make an IT system.
    // I tell and you make.
    // I need a system to review my cakes. I have many cakes. I need a system.
    // Every cake must have following properties. Size: big/small. Sweetness: medium/sweet. These are mandatory as there must be ordnung.
    // In addition I want to search by ingredients and toppings, these are not necessary.
    // I strive for perfection.
    // Every day I bake a new cake. I must add it to the cakes. Sell it to my loyal customers.
    // I also make my cakes better. I am an artist and I improve my recipes.
    // I take existing Sachertorte and I make it better and next week I make it better and next week...
    // Can you do this? I need this system tomorrow!
    //todo here are some examples of empty methods


    @PostMapping
    fun addCake(
            @RequestBody cake: Cake
    ): Cake {
        // Adds new cake to repo
        return emptyMethodReturn1()
    }

    @GetMapping
    fun searchCakes(
            @RequestParam size: String,
            @RequestParam sweetness: String,
            @RequestParam(required = false) ingredients: String?,
            @RequestParam(required = false) toppings: String?
    ): List<Cake> {
        // Return all cakes if no search parameters were given
        if(listOfNotNull(ingredients, toppings).isEmpty()){
            return emptyMethodReturnList()
        }

        // returns cakes that match to searching criterias

        return emptyMethodReturnList()
    }

    @GetMapping("/{id}")
    fun getCakeById(
            @PathVariable id: String
    ): Cake {
        // return exact cake by ID
        return emptyMethodReturn1()
    }

    @PutMapping("/{id}")
    fun updateCake(
            @PathVariable id: Long,
            @RequestBody cake: Cake
    ): Cake {
        // finds cake by ID and updates it with Request Params
        return emptyMethodReturn1()
    }

    fun emptyMethodReturnList(): List<Cake> {
        return listOf()
    }

    fun emptyMethodReturn1(): Cake {
        return Cake()
    }

    fun emptyMethodVoid() {}
}