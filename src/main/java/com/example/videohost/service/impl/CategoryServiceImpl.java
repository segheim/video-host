package com.example.videohost.service.impl;

import com.example.videohost.exception.NotFoundException;
import com.example.videohost.model.Category;
import com.example.videohost.repository.CategoryRepository;
import com.example.videohost.service.CategoryService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }
}
