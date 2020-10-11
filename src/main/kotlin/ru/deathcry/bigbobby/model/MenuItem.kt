package ru.deathcry.bigbobby.model

import javax.persistence.*

@Entity
@Table(name = "menu")
public class MenuItem(
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long = -1,

    @Column(length = 32)
    val name: String = "",

    @Column(length = 64)
    val lang_key: String = "",

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL])
    val ingredients: List<Ingredient>? = null,

    @Column
    val price: Double = 0.0,

    @Column
    val weight: Double = 0.0,

    @Column
    val keywords: String = ""
){
  override fun toString(): String{
        return "Customer[id=${id}, name=${name}, lang_key=${lang_key}, ingredients=${ingredients}, price=${price}, weight=${price}, keywords=${price}]"
  }
}