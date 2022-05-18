package ru.itis.kurguskina.internet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.internet.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}