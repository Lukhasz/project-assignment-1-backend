package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

}
