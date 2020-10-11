package ru.deathcry.bigbobby.model

import ru.deathcry.bigbobby.model.converter.StringListConverter
import javax.persistence.*

@Entity
@Table(name = "ingredients")
public class Ingredient(
    @Column(length = 32)
    val name: String = "",

    @Column(length = 64)
    val lang_key: String = "",

    @Column(length = 20)
    val type: String = "",

    @Column(nullable = true)
    @Convert(converter = StringListConverter::class)
    val allergens: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    override fun toString(): String {
        return "Ingredient[id=${id}, name=${name}, lang_key=${lang_key}, type=${type}, allergens=${allergens}]"
    }
}