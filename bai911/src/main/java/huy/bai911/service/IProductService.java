package huy.bai911.service;

import huy.bai911.module.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface IProductService {
    List<Product>findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
}
