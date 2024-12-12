package com.ecom.productcatalog.Controller;

import com.ecom.productcatalog.Service.CategoryService;
import com.ecom.productcatalog.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CatergoryController {
    private final CategoryService categoryService;

    public CatergoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllCategories(){
        return categoryService.getAllCategories();
    }

}
