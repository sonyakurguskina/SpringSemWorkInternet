package ru.itis.kurguskina.springsemworkinternet.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import ru.itis.kurguskina.springsemworkinternet.models.Product;

public interface ProductService{
    @NotNull
    Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") Long id);

    Product save(Product product);
}
