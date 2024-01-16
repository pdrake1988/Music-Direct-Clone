package com.pdrake.musicdirectclone.entities

import jakarta.persistence.*

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null
}
