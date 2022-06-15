package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.Category;
import com.grupo7.airbnbclone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.searchCategoryById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Category>> searchAll(){
        return ResponseEntity.ok(categoryService.searchAllCategories());
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category){
        ResponseEntity<Category> response = null;
        if (category.getId() != null && categoryService.searchCategoryById(category.getId()).isPresent()){
            response = ResponseEntity.ok(categoryService.updateCategory(category));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (categoryService.searchCategoryById(id).isPresent()){
            categoryService.deleteCategory(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
