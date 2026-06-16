package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.User;
import platform.service.UserService;
import platform.util.Result;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        try {
            User registered = userService.register(user);
            return Result.success(registered);
        } catch (Exception e) {
            return Result.error("注册失败：" + e.getMessage());
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        try {
            User loggedUser = userService.login(user.getUsername(), user.getPassword());
            if (loggedUser != null) {
                return Result.success(loggedUser);
            } else {
                return Result.error("用户名或密码错误");
            }
        } catch (Exception e) {
            return Result.error("登录失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            User user = userService.getById(id);
            return Result.success(user);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        try {
            int result = userService.update(user);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("更新失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = userService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }
}