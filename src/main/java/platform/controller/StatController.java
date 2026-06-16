package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.service.CategoryService;
import platform.service.MovieBookService;
import platform.util.Result;

import java.util.Map;

@RestController
@RequestMapping("/stat")

public class StatController {

    @Autowired
    private MovieBookService movieBookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/overview")
    public Result getOverview() {
        try {
            // 优雅解耦：直接合并调用 Service 对应 MyBatis 调用的 proc_stat 存储过程，不再出现僵尸代码与硬编码
            Map<String, Object> data = movieBookService.getStatsOverview();
            return Result.success(data);
        } catch (Exception e) {
            return Result.error("统计报表获取失败：" + e.getMessage());
        }
    }

    @GetMapping("/categories")
    public Result getCategories() {
        try {
            return Result.success(categoryService.getAll());
        } catch (Exception e) {
            return Result.error("分类树形数据查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/hot")
    public Result getHot(@RequestParam(defaultValue = "10") Integer limit) {
        try {
            return Result.success(movieBookService.getHot(limit));
        } catch (Exception e) {
            return Result.error("热度趋势分析失败：" + e.getMessage());
        }
    }
}