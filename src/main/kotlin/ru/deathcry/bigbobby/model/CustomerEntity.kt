package ru.deathcry.bigbobby.model

import com.sun.istack.NotNull
import ru.deathcry.bigbobby.util.Authorities
import javax.persistence.*

@Entity
@Table(name = "customers")
class CustomerEntity(
    @Column(name = "email", length = 64, unique=true)
    @NotNull
    val email: String = "",

    @Column(name = "password", length = 128)
    val password: String = "",

    @Column(name = "firstname", length = 20)
    val firstName: String = "",

    @Column(name = "lastname", length = 20)
    val lastName: String = "",

    @Column(name = "phone", length = 16)
    val phone: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    fun getAuthorities() = listOf(Authorities.USER)

    override fun toString(): String {
        return "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}]"
    }
}