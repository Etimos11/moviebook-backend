package platform.service;

import platform.entity.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User getById(Integer id);
    int update(User user);
    int delete(Integer id);
}