package com.epam.spring.mapper;

import com.epam.spring.dto.CategoryDto;
import com.epam.spring.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ServiceMapper.class)
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  Category mapCategoryDtoToCategory(CategoryDto categoryDto);

  CategoryDto mapCategoryToCategoryDto(Category category);
}
