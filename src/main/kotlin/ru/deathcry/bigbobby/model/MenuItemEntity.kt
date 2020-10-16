package ru.deathcry.bigbobby.model

import ru.deathcry.bigbobby.dto.MenuItemDto
import ru.deathcry.bigbobby.model.converter.StringListConverter
import ru.deathcry.bigbobby.util.IMorphable
import ru.deathcry.bigbobby.util.morph
import javax.persistence.*

@Entity
@Table(name = "menu")
public class MenuItemEntity(
    @Column(length = 32, unique = true)
    val name: String = "",

    @Column(length = 64)
    val lang_key: String = "",

    @ManyToMany(cascade = [CascadeType.ALL])
    val ingredients: List<IngredientEntity> = mutableListOf(),

    @Column
    val price: Double = 0.0,

    @Column
    val weight: Double = 0.0,

    @Column(nullable = true)
    @Convert(converter = StringListConverter::class)
    val keywords: List<String> = mutableListOf()
): IMorphable<MenuItemDto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1

    constructor(dto: MenuItemDto): this(dto.name, dto.lang_key, dto.ingredients.morph(), dto.price, dto.weight, dto.keywords)

    override fun toString(): String {
        return "Customer[id=${id}, name=${name}, lang_key=${lang_key}, ingredients=${ingredients}, price=${price}, weight=${price}, keywords=${price}]"
    }

    override fun morph(): MenuItemDto {
        return MenuItemDto(this)
    }
}