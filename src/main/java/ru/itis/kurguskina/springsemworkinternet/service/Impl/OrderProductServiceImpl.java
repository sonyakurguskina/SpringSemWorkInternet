package ru.itis.kurguskina.springsemworkinternet.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.kurguskina.springsemworkinternet.models.OrderProduct;
import ru.itis.kurguskina.springsemworkinternet.repositories.OrderProductRepository;
import ru.itis.kurguskina.springsemworkinternet.service.OrderProductService;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
