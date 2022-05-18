package ru.itis.kurguskina.springsemworkinternet.service;

import org.springframework.validation.annotation.Validated;
import ru.itis.kurguskina.springsemworkinternet.models.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}