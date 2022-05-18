package ru.itis.kurguskina.internet.controllers;

import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kurguskina.internet.models.Product;
import ru.itis.kurguskina.internet.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull
    Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}