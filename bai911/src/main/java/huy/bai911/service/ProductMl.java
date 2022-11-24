package huy.bai911.service;

import huy.bai911.module.Product;
import huy.bai911.security.IProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductMl implements IProductService{
    @Autowired
    private IProductSer productSer;
    @Override
    public List<huy.bai911.module.Product> findAll() {
        return (List<Product>) productSer.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productSer.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productSer.save(product);
    }
}
