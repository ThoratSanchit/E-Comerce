package E_comerce.example.E_comerce.services.impl;

import E_comerce.example.E_comerce.model.Products;
import E_comerce.example.E_comerce.repository.ProductRepository;
import E_comerce.example.E_comerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Products> searchProducts(String keyword) {
        List<Products> byName = productRepository.findByNameContainingIgnoreCase(keyword);
        List<Products> byDescription = productRepository.findByDescriptionContainingIgnoreCase(keyword);

        List<Products> result = new ArrayList<>(byName);
        for (Products p : byDescription) {
            if (!result.contains(p)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Products> searchProductsByCategory(String keyword) {
        return  productRepository.findByCategory(keyword);
    }
}
