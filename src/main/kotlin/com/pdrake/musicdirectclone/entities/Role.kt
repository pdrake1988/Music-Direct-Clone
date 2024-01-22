package com.pdrake.musicdirectclone.entities

import jakarta.persistence.*

@Entity
@Table(name = "ROLE")
class Role(
    @ManyToOne()
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    val account: Account,
    @Column(name = "AUTHORITY", length = 20, nullable = false)
    val authority: String
) : BaseEntity()
