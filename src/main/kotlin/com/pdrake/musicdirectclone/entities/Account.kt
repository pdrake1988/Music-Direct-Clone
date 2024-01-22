package com.pdrake.musicdirectclone.entities

import jakarta.persistence.*

@Entity
@Table(name = "ACCOUNT")
class Account(
    @Column(name = "USERNAME", length = 20, nullable = false)
    val username: String,
    @Column(name = "PASSWORD", length = 255, nullable = false)
    val password: String,
    @Column(name = "ADDRESS", length = 30, nullable = false)
    val address: String,
) : BaseEntity() {
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    val roles: List<Role> = listOf()

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    val cart: Cart? = null
}
