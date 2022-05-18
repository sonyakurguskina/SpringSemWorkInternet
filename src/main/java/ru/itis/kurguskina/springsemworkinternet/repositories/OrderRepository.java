package ru.itis.kurguskina.springsemworkinternet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.springsemworkinternet.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
