package ru.deathcry.bigbobby.model

import ru.deathcry.bigbobby.model.converter.StringListConverter
import javax.persistence.*

@Entity
@Table(name = "menu")
public class MenuItemEntity(
    @Column(length = 32)
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
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1

    override fun toString(): String {
        return "Customer[id=${id}, name=${name}, lang_key=${lang_key}, ingredients=${ingredients}, price=${price}, weight=${price}, keywords=${price}]"
    }
}