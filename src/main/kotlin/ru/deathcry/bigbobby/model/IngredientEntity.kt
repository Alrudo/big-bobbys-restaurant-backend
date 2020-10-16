package ru.deathcry.bigbobby.model

import ru.deathcry.bigbobby.dto.IngredientDto
import ru.deathcry.bigbobby.model.converter.StringListConverter
import ru.deathcry.bigbobby.util.IMorphable
import javax.persistence.*

@Entity
@Table(name = "ingredients")
public class IngredientEntity(
    @Column(length = 32)
    val name: String = "",

    @Column(length = 64)
    val lang_key: String = "",

    @Column(length = 20)
    val type: String = "",

    @Column(nullable = true)
    @Convert(converter = StringListConverter::class)
    val allergens: List<String> = listOf()
): IMorphable<IngredientDto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    constructor(dto: IngredientDto): this(dto.name, dto.lang_key, dto.type, dto.allergens)

    override fun toString(): String {
        return "Ingredient[id=${id}, name=${name}, lang_key=${lang_key}, type=${type}, allergens=${allergens}]"
    }

    override fun morph(): IngredientDto {
        return IngredientDto(this)
    }
}