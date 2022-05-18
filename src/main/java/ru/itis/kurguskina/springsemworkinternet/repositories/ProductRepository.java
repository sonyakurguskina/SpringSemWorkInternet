package ru.itis.kurguskina.springsemworkinternet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.springsemworkinternet.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}