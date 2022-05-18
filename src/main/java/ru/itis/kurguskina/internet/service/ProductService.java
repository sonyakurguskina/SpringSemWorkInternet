package ru.itis.kurguskina.internet.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import ru.itis.kurguskina.internet.models.Product;

public interface ProductService{
    @NotNull
    Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") Long id);

    Product save(Product product);
}
