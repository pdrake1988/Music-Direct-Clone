package com.pdrake.musicdirectclone.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class RegisterDto(
    @field:NotBlank(message = "Username is required")
    val username: String,
    @field:NotBlank(message = "Password is required")
    @field:Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{6,}$",
        message = "Password must have at least one special character"
    )
    val password: String,
    @field:NotBlank(message = "Address is required")
    val address: String,
    @field:NotBlank(message = "Role is required")
    val role: String
)
