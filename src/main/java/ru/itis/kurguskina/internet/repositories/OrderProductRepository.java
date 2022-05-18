package ru.itis.kurguskina.internet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.internet.models.OrderProduct;
import ru.itis.kurguskina.internet.models.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
