package com.ecom.productcatalog.Service;

import com.ecom.productcatalog.Repository.ProductRepository;
import com.ecom.productcatalog.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategoryId(Long categoryid){
        List<Product>products = productRepository.findByCategoryId(categoryid);
        System.out.println("Fetched products:"+products);
        return products;
    }


}
