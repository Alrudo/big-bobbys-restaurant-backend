package ru.deathcry.bigbobby.model

import javax.persistence.*

@Entity
@Table(name = "order_items")
public class OrderItemEntity(
        @ManyToOne(fetch = FetchType.LAZY)
    val order: OrderEntity = OrderEntity(),

        @JoinColumn
    @OneToOne(cascade = [CascadeType.ALL])
    val item: MenuItemEntity = MenuItemEntity(),

        @Column
    val amount: Int = 1

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}