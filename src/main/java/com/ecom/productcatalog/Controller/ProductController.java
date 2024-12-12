package com.ecom.productcatalog.Controller;

import com.ecom.productcatalog.Service.ProductService;
import com.ecom.productcatalog.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryid}")
    public List<Product> getAllProducts(@PathVariable Long categoryid){
        return productService.getAllProductsByCategoryId(categoryid);
    }
}
