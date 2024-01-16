package com.pdrake.musicdirectclone.dtos

import jakarta.validation.constraints.NotBlank
import org.springframework.security.web.csrf.CsrfToken

data class Product(
    @NotBlank(message = "Name is required")
    val name: String,
    @NotBlank(message = "Category is required")
    val category: String,
    @NotBlank(message = "Quantity is required")
    val quantity: Int,
    val csrfToken: CsrfToken
)
