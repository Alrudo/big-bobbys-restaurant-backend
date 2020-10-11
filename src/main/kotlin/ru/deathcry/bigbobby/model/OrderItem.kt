package ru.deathcry.bigbobby.model

import javax.persistence.*

@Entity
@Table(name = "order_items")
public class OrderItem(
    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order = Order(),

    @JoinColumn
    @OneToOne(cascade = [CascadeType.ALL])
    val item: MenuItem = MenuItem(),

    @Column
    val amount: Int = 1

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}