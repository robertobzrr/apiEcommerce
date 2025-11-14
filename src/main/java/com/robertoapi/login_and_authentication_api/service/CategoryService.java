package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.model.Category;
import com.robertoapi.login_and_authentication_api.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

//------------------------------------------------------------------------------------------

    public void createCategory(Category category){
        categoryRepository.save(category);
    }


    public List<Category> findAllCategorys(){
        return categoryRepository.findAll();
    }


    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }


    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }


    public void updateCategoryById(Long id, Category updateCategory){
        Optional<Category> categoryDB = findCategoryById(id);

        if(categoryDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        else{
            Category editCategory = categoryDB.get();

            editCategory.setNameCategory(updateCategory.getNameCategory());

            categoryRepository.save(editCategory);

        }

    }



}
