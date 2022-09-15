package com.epam.spring.controller;

import com.epam.spring.dto.CategoryDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
  private final CategoryService categoryService;

  @ApiOperation("Create a category")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CategoryDto createCategory(
      @Validated(OnCreate.class) @RequestBody CategoryDto categoryDto) {
    return categoryService.createCategory(categoryDto);
  }

  @ApiOperation("Get a category by id")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "category id")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public CategoryDto getCategory(@PathVariable Integer id) {
    return categoryService.getCategory(id);
  }
}
