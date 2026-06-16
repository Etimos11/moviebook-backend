package platform.mapper;

import platform.entity.Category;

import java.util.List;


public interface CategoryMapper {
    int insert(Category category);
    Category selectById(Integer id);
    List<Category> selectAll();
    int update(Category category);
    int delete(Integer id);
}