package ru.itis.kurguskina.springsemworkinternet.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.kurguskina.springsemworkinternet.models.OrderProduct;
import ru.itis.kurguskina.springsemworkinternet.models.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
