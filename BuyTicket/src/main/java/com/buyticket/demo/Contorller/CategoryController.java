package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Category;
import com.buyticket.demo.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> findAllCategories(){
        return categoryService.findAll();
    }
    @GetMapping("{id}")
    public Optional<Category> findById(@PathVariable  Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/tmp")
    public List<Category> tmp(@RequestParam String name) {
        return categoryService.tmp(name);
    }


}
