package huy.bai911.security;

import huy.bai911.module.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductSer extends CrudRepository<Product,Long> {
}
