package E_comerce.example.E_comerce.services.impl;

import E_comerce.example.E_comerce.repository.ProductRepository;
import E_comerce.example.E_comerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
}
