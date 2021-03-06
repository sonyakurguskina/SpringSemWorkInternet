package ru.itis.kurguskina.springsemworkinternet.service.Impl;

import org.springframework.stereotype.Service;
import ru.itis.kurguskina.springsemworkinternet.helper.exceptions.ResourceNotFoundException;
import ru.itis.kurguskina.springsemworkinternet.models.Product;
import ru.itis.kurguskina.springsemworkinternet.repositories.ProductRepository;
import ru.itis.kurguskina.springsemworkinternet.service.ProductService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
