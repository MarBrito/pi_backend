package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.Category;
import com.grupo7.airbnbclone.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category){return categoryRepository.save(category);}
    public List<Category> searchAllCategories(){return categoryRepository.findAll();}
    public Optional<Category> searchCategoryById(Integer id){return categoryRepository.findById(id);}
    public Category updateCategory(Category category){return categoryRepository.save(category);}
    public void deleteCategory(Integer id){categoryRepository.deleteById(id);}


}
