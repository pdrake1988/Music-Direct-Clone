package com.pdrake.musicdirectclone.controllers

import com.pdrake.musicdirectclone.dtos.ProductDto
import com.pdrake.musicdirectclone.entities.Product
import com.pdrake.musicdirectclone.repos.ProductRepository
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@Controller
class ProductController(
    private val productRepository: ProductRepository
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

    @PostMapping("/new-product")
    @PreAuthorize(value = "hasRole('ADMIN')")
    fun newProduct(@Valid @ModelAttribute productDto: ProductDto): String {
        val newProduct = Product(productDto.name, productDto.description, productDto.category, productDto.quantity)
        productRepository.save(newProduct)
        return "redirect:/"
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun error(ex: MethodArgumentNotValidException, model: ModelAndView): ModelAndView {
        model.addObject("errors", ex)
        model.viewName = "error"
        return model
    }
}
