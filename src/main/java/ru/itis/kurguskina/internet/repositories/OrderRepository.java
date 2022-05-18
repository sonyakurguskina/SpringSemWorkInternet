package ru.itis.kurguskina.internet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.internet.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
