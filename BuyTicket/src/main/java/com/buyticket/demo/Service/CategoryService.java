package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Category;
import com.buyticket.demo.Repository.CategortyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategortyRepository categortyRepository;

    public Category save(Category category) {
        return categortyRepository.save(category);
    }

    public Optional<Category> findbyId(Long id) {
        return categortyRepository.findById(id);
    }

    public List<Category> findAll() {
        return categortyRepository.findAll();
    }

    public List<Category> getCategoryByEventName(String name) {
        return categortyRepository.findAllByEventName(name);
    }

    public void deleteCategory(Long id){
        categortyRepository.deleteById(id);
    }

    public Optional<Category> findById(Long id){
        return categortyRepository.findById(id);
    }
}
