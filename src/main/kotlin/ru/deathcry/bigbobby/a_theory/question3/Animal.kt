package ru.deathcry.bigbobby.a_theory.question3

import kotlin.math.min

abstract class Animal(val name: String) {
    var mood: Int = 50
    var hunger: Int = 50

    abstract fun pat(): String
    abstract fun giveTreat(treat: String): String
    abstract fun getMood(): String
    abstract fun getHunger(): String
}

class Tiger(name: String): Animal(name) {

    override fun pat(): String {
        if(mood < 10 || hunger < 10){
            return "Holy shit, tiger `$name` bite off your leg, someone call an ambulance!"
        }
        if(hunger < 30){
            return "Tiger `$name` bite your hand a little, maybe you should give him a little treat?"
        }
        if(mood < 30){
            return "Tiger `$name` refuses your actions and goes away"
        }

        this.mood = min(100, this.mood + 5)
        return "Tiger `$name` makes some purry and funny noises, he seems to like it"
    }

    override fun giveTreat(treat: String): String {
        val (hunger, mood) = when(treat.toLowerCase()){
            "beef" -> 20 to 10
            "pork" -> 20 to -5
            "chicken" -> 10 to 25
            else -> return "Tiger `$name` don't want to eat `$treat`"
        }

        if(this.hunger + hunger > 100){
            return "Tiger `$name` doesn't seem to want to eat"
        }
        this.hunger = min(100, this.hunger + hunger)
        this.mood = min(100, this.mood + mood)

        val comment = if (mood < 0) "but seems that he didn't like it" else "he really enjoyed it"
        return "Tiger `$name` ate `$treat`, $comment"
    }

    override fun getMood(): String {
        return when{
            mood < 10 -> "Oh my, tiger `$name` is really angry now, it's better to be aware"
            mood < 30 -> "Tiger `$name` seems to be very unpleased with something"
            mood < 50 -> "Tiger `$name` is looking pretty neutral"
            mood < 80 -> "Tiger `$name`s tail is happily wiggling"
            else -> "Hah, look, tiger `$name` is lying on his back and making funny sounds"
        }
    }

    override fun getHunger(): String {
        return when{
            hunger < 10 -> "Hurry up and feed tiger `$name` or he will eat you!"
            mood < 30 -> "Tiger `$name` seems to be pretty hungry"
            mood < 50 -> "Tiger `$name` definitely wants some treat"
            mood < 80 -> "Tiger `$name` would be happy about a little piece of chicken"
            else -> "Ugh, i guess its time to stop feeding tiger `$name`"
        }
    }

}