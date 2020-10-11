package ru.deathcry.bigbobby.a_theory.question6.sheep

class SheepFarm {
    //todo for question 6 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite
    //todo create a working api for a sheep farm
    // It compiles and runs. You need to use proper annotations, methods, etc, however to ease the process you can use empty methods (examples below).
    // Follow the story to have only the necessary methods in it
    //todo 1
    // Ireland.
    // Sheep.
    // Ireland. The land of the sheep.
    // My name's Liam. I have sheep. Many, many sheep.
    // What do you call a sheep covered in chocolate? - A Candy Baa.
    // Yeah, that's a very funny. Jokes aside.
    // I need a backoffice system for my sheep.
    // The sheep in Ireland are in flux. They come, they go.
    // There are new sheep coming here all the time. I need to store new sheep to the database.
    // And then there are sheep leaving. They run away. I remember all my sheep.
    // The ones that are not there I want to remove them from my database.
    // Each sheep has a unique collar with a special code. I've always numbered my sheep.
    // Special code is just a number. It's a basic incrementing number, but I call it special because I can.
    // I want to access sheep details, it's name, age, everything using that code.
    // That's it. Can you do that for me?
    //todo here are some examples of empty

    private var id: Long = 0
    private val sheeps: MutableMap<Long, Sheep> = mutableMapOf()

    /**
     * Add new sheep to the farm and pass it given name, age and color as well as assign it a unique id.
     *
     * @throws InvalidDataException when the sheep age given is below 0.
     */
    fun addSheep(name: String, age: Int, color: String) {
        if (age < 0) throw InvalidDataException("Sheep can not have age lower than 0.")
        sheeps[id] = Sheep(id, name, age, color)
        id++
    }

    /**
     * Collect all sheeps from MutableMap into a list and sort them by their id.
     *
     * @return List of Sheeps objects sorted by their id number.
     */
    fun getAllSheeps(): List<Sheep> {
        return sheeps.values.toList().sortedBy { it.id }
    }

    /**
     * Get a certain sheep by its id.
     *
     * @return returns Sheep object if such exists, otherwise returns null.
     */
    fun getSheep(id: Long): Sheep? {
        return sheeps[id]
    }

    /**
     * Remove the specified sheep from the farm by its object.
     *
     * @return Boolean whether the Sheep object was removed or not.
     */
    fun removeSheep(sheep: Sheep): Boolean {
        val id = sheeps.filterValues { it == sheep }.keys.firstOrNull() ?: return false
        sheeps.remove(id)
        return true
    }

    /**
     * Remove the specified sheep from the farm by its id.
     *
     * @return Boolean whether the Sheep object was removed or not.
     */
    fun removeSheep(id: Long): Boolean {
        val sheep = sheeps.remove(id)
        return sheep != null
    }
}
