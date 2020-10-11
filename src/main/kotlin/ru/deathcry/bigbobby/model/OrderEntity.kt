package ru.deathcry.bigbobby.model

import javax.persistence.*

@Entity
@Table(name = "orders")
public class OrderEntity(
    @Column(length = 24)
    val name: String = "",

    @Column(length = 16)
    val phone: String = "",

    @JoinColumn(nullable = true)
    @OneToOne(cascade = [CascadeType.ALL])
    val customer: CustomerEntity? = null,

    @Column
    @OneToMany(
    mappedBy = "order",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
    )
    val items: List<OrderItemEntity> = listOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    override fun toString(): String {
        return "Order[id=${id}, name=${name}, phone=${phone}, isCustomer=${customer != null}]"
    }
}