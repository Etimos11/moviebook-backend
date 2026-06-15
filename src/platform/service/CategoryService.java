package platform.service;

import platform.entity.Category;

import java.util.List;

public interface CategoryService {
    int add(Category category);
    Category getById(Integer id);
    List<Category> getAll();
    int update(Category category);
    int delete(Integer id);
}