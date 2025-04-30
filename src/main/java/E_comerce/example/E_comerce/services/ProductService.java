package E_comerce.example.E_comerce.services;

import E_comerce.example.E_comerce.model.Products;
import java.util.List;

public interface ProductService {
    Products addProduct(Products product);
    List<Products> getAllProducts();
    Products getProductById(String id);
    void deleteProduct(String id);

//    Products createProduct(Products product);
    List<Products> searchProducts(String keyword);
    List<Products> searchProductsByCategory(String keyword);
}
