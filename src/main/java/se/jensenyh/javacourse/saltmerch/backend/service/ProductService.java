package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }

    public List<Product> getAllFromSpecificCategory(String str) {
        return productRepository.selectAllOfCategory(str);
    }

    public Product getSpecificProduct(int id) {
        return productRepository.getEntireProduct(id);
    }

}
