package platform.mapper;

import platform.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    int insert(User user);
    User selectById(Integer id);
    User selectByUsername(String username);
    int update(User user);
    int delete(Integer id);
}