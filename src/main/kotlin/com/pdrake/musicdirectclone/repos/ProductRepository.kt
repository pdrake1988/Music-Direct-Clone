package com.pdrake.musicdirectclone.repos

import com.pdrake.musicdirectclone.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findProductByCategory(category: String): List<Product>
}
