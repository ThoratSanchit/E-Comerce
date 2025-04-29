package E_comerce.example.E_comerce.controller;

import E_comerce.example.E_comerce.model.Products;
import E_comerce.example.E_comerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }


    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable String id, @RequestBody Products updatedProduct) {
        Products existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            return productService.addProduct(existingProduct);
        }
        return null;
    }

    @GetMapping("/search")
    public List<Products> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

}
