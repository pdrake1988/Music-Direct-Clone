package com.pdrake.musicdirectclone.controllers

import com.pdrake.musicdirectclone.repos.ProductRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class ProductController(
    private val productRepository: ProductRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @GetMapping("/")
    fun home(model: Model): String {
        val products = productRepository.findAll()
        model.addAttribute("products", products)
        return "homepage"
    }

    @GetMapping("/{category}")
    fun filterProducts(@PathVariable category: String, model: Model): String {
        val products = productRepository.findProductByCategory(category)
        model.addAttribute("products", products)
        return "homepage"
    }
}
