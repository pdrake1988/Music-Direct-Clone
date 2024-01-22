package com.pdrake.musicdirectclone.entities

import jakarta.persistence.*

@Entity
@Table(name = "PRODUCT")
class Product(
    @Column(name = "NAME", length = 20, nullable = false)
    val name: String,
    @Column(name = "DESCRIPTION", length = 255, nullable = false)
    val description: String,
    @Column(name = "CATEGORY", length = 20, nullable = false)
    val category: String,
    @Column(name = "QUANTITY", nullable = false)
    val quantity: Int
) : BaseEntity() {
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "CART_ITEMS",
        joinColumns = [JoinColumn(name = "ACCOUNT_ID", nullable = false)],
        inverseJoinColumns = [JoinColumn(name = "PRODUCT_ID", nullable = false)]
    )
    val cart: MutableList<Cart> = mutableListOf()
}
