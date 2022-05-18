package ru.itis.kurguskina.internet.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import ru.itis.kurguskina.internet.models.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}