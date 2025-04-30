package E_comerce.example.E_comerce.services;



import E_comerce.example.E_comerce.model.Cart;
import E_comerce.example.E_comerce.model.Products;
import E_comerce.example.E_comerce.repository.CartRepository;
import E_comerce.example.E_comerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CartService {

    @Autowired
    private  CartRepository cartRepository;
    @Autowired
    private  ProductRepository productRepository;

    public Cart addToCart(String email, String productId) {
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByEmail(email).orElseGet(() -> new Cart(null, email, new java.util.ArrayList<>(), 0.0));

        cart.getItems().add(product);
        cart.setTotalPrice(cart.getItems().stream().mapToDouble(Products::getPrice).sum());

        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartByEmail(String email) {
        return cartRepository.findByEmail(email);
    }

    public Cart updateCart(String email, List<Products> updatedItems) {
        Cart cart = cartRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.setItems(updatedItems);
        cart.setTotalPrice(updatedItems.stream().mapToDouble(Products::getPrice).sum());

        return cartRepository.save(cart);
    }

    public String deleteCart(String email) {
        Cart cart = cartRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cartRepository.delete(cart);
        return "Cart deleted for email: " + email;
    }
}

