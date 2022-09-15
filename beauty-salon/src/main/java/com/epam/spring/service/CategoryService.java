package com.epam.spring.service;

import com.epam.spring.dto.CategoryDto;

public interface CategoryService {
  CategoryDto createCategory(CategoryDto categoryDto);

  CategoryDto getCategory(Integer id);
}
