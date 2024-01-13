package com.pdrake.musicdirectclone.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class Register(
    @NotBlank(message = "Username is required")
    val username: String,
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "[a-zA-Z0-9\\W{1}]+", message = "Password must have at least one special character")
    val password: String,
    @NotBlank(message = "Address is required")
    val address: String,
    @NotBlank(message = "Role is required")
    val roles: List<String>
)
