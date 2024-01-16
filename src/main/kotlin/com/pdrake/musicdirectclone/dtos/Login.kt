package com.pdrake.musicdirectclone.dtos

import jakarta.validation.constraints.NotBlank

data class Login(
    @NotBlank(message = "Username is required")
    val username: String,
    @NotBlank(message = "Password is required")
    val password: String
)
