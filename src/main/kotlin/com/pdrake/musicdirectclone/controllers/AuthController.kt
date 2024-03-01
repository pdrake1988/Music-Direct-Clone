package com.pdrake.musicdirectclone.controllers

import com.pdrake.musicdirectclone.dtos.RegisterDto
import com.pdrake.musicdirectclone.entities.Account
import com.pdrake.musicdirectclone.entities.Role
import com.pdrake.musicdirectclone.repos.AccountRepository
import com.pdrake.musicdirectclone.repos.RoleRepository
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

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
    fun register(): ModelAndView {
        val model = ModelAndView()
        model.addObject("errors", null)
        model.viewName = "register"
        return model
    }

    @PostMapping("/register")
    fun register(@Valid registerDto: RegisterDto): String {
        val account = Account(registerDto.username, passwordEncoder.encode(registerDto.password), registerDto.address)
        val role = Role(account, registerDto.role)
        accountRepository.save(account)
        roleRepository.save(role)
        return "redirect:/"
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun error(ex: MethodArgumentNotValidException): ModelAndView {
        val model = ModelAndView()
        model.addObject("errors", ex.allErrors)
        model.viewName = "register"
        return model
    }
}
