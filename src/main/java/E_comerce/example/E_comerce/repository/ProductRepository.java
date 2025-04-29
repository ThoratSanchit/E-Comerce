package E_comerce.example.E_comerce.repository;

import E_comerce.example.E_comerce.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Products, String> {
    List<Products> findByNameContainingIgnoreCase(String keyword);
    List<Products> findByDescriptionContainingIgnoreCase(String keyword);
}
