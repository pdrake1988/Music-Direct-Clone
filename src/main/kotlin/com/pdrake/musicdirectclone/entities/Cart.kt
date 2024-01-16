package com.pdrake.musicdirectclone.entities

import jakarta.persistence.*

@Entity
@Table(name = "CART")
class Cart(
    @OneToOne
    @MapsId
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    val account: Account
) : BaseEntity() {
    @ManyToMany(mappedBy = "cart")
    val product: MutableList<Product> = mutableListOf()
}
