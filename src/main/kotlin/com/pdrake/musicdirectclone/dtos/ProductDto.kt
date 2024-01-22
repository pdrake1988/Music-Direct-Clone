package com.pdrake.musicdirectclone.dtos

import jakarta.validation.constraints.NotBlank

data class ProductDto(
    @NotBlank(message = "Name is required")
    val name: String,
    @NotBlank(message = "Description is required")
    val description: String,
    @NotBlank(message = "Category is required")
    val category: String,
    @NotBlank(message = "Quantity is required")
    val quantity: Int
)
