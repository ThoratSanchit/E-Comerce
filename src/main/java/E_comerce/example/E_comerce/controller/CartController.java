package E_comerce.example.E_comerce.controller;


import E_comerce.example.E_comerce.model.Cart;
import E_comerce.example.E_comerce.model.Products;

import E_comerce.example.E_comerce.services.CartService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")

public class CartController {

    @Autowired
    private  CartService cartService;


    @PostMapping("/add")
    public Cart addToCart(@RequestBody AddRequest request) {
        return cartService.addToCart(request.getEmail(), request.getProductId());
    }


    @GetMapping("/all")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    // ✅ Read cart by email
    @GetMapping("/{email}")
    public ResponseEntity<Map<String, Object>> getCartSummary(@PathVariable String email) {
        Cart cart = cartService.getCartByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Map<String, Object> response = new HashMap<>();
        response.put("cartItems", cart.getItems());
        response.put("totalItems", cart.getItems().size());
        return ResponseEntity.ok(response);
    }


    // ✅ Update cart items
    @PutMapping("/update")
    public Cart updateCart(@RequestBody UpdateRequest request) {
        return cartService.updateCart(request.getEmail(), request.getItems());
    }

    // ✅ Delete cart by email
    @DeleteMapping("/{email}")
    public String deleteCart(@PathVariable String email) {
        return cartService.deleteCart(email);
    }

    @Data
    static class AddRequest {
        private String email;
        private String productId;
    }

    @Data
    static class UpdateRequest {
        private String email;
        private List<Products> items;
    }
}
