package com.epam.spring.service.impl;

import com.epam.spring.dto.CategoryDto;
import com.epam.spring.mapper.CategoryMapper;
import com.epam.spring.model.Category;
import com.epam.spring.repository.CategoryRepository;
import com.epam.spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  @Override
  public CategoryDto createCategory(CategoryDto categoryDto) {
    log.info("create category {}", categoryDto.getName());
    Category category = CategoryMapper.INSTANCE.mapCategoryDtoToCategory(categoryDto);
    category = categoryRepository.save(category);
    return CategoryMapper.INSTANCE.mapCategoryToCategoryDto(category);
  }

  @Override
  public CategoryDto getCategory(Integer id) {
    log.info("get category by id {}", id);
    Category category = categoryRepository.getById(id);
    return CategoryMapper.INSTANCE.mapCategoryToCategoryDto(category);
  }
}
