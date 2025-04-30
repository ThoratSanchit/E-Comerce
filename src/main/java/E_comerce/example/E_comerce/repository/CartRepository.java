package E_comerce.example.E_comerce.repository;

import E_comerce.example.E_comerce.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByEmail(String email);
}
