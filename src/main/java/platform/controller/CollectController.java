package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.Collect;
import platform.service.CollectService;
import platform.util.Result;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("/add")
    public Result add(@RequestBody Collect collect) {
        try {
            int result = collectService.add(collect);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("收藏失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            Collect collect = collectService.getById(id);
            return Result.success(collect);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        try {
            List<Collect> list = collectService.getByUserId(userId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/mb/{mbId}")
    public Result getByMbId(@PathVariable Integer mbId) {
        try {
            List<Collect> list = collectService.getByMbId(mbId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = collectService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/cancel")
    public Result cancel(@RequestParam Integer userId, @RequestParam Integer mbId) {
        try {
            int result = collectService.cancel(userId, mbId);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("取消收藏失败：" + e.getMessage());
        }
    }

    @GetMapping("/check")
    public Result check(@RequestParam Integer userId, @RequestParam Integer mbId) {
        try {
            boolean isCollected = collectService.isCollected(userId, mbId);
            return Result.success(isCollected);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }
}