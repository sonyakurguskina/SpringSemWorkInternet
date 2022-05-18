package ru.itis.kurguskina.internet.service.Impl;

import org.springframework.stereotype.Service;
import ru.itis.kurguskina.internet.helper.exceptions.ResourceNotFoundException;
import ru.itis.kurguskina.internet.models.Product;
import ru.itis.kurguskina.internet.repositories.ProductRepository;
import ru.itis.kurguskina.internet.service.ProductService;

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
