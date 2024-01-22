package com.pdrake.musicdirectclone.controllers

import com.pdrake.musicdirectclone.dtos.Register
import com.pdrake.musicdirectclone.entities.Account
import com.pdrake.musicdirectclone.entities.Role
import com.pdrake.musicdirectclone.repos.AccountRepository
import com.pdrake.musicdirectclone.repos.RoleRepository
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/auth")
class AuthController(
    private val passwordEncoder: PasswordEncoder,
    private val accountRepository: AccountRepository,
    private val roleRepository: RoleRepository
) {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/register")
    fun register(): String {
        return "register"
    }

    @PostMapping("/register")
    fun register(@Valid register: Register): String {
        val account = Account(register.username, passwordEncoder.encode(register.password), register.address)
        val role = Role(account, register.role)
        accountRepository.save(account)
        roleRepository.save(role)
        return "redirect:/"
    }
}
