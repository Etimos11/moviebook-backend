package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.MovieBook;
import platform.service.MovieBookService;
import platform.util.Result;

import java.util.List;

@RestController
@RequestMapping("/moviebook")

public class MovieBookController {

    @Autowired
    private MovieBookService movieBookService;

    @PostMapping("/add")
    public Result add(@RequestBody MovieBook movieBook) {
        try {
            int result = movieBookService.add(movieBook);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("添加失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            MovieBook movieBook = movieBookService.getById(id);
            return Result.success(movieBook);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/type/{type}")
    public Result getByType(@PathVariable Integer type) {
        try {
            List<MovieBook> list = movieBookService.getByType(type);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/category/{categoryId}")
    public Result getByCategory(@PathVariable Integer categoryId) {
        try {
            List<MovieBook> list = movieBookService.getByCategory(categoryId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/audit/{status}")
    public Result getByAuditStatus(@PathVariable Integer status) {
        try {
            List<MovieBook> list = movieBookService.getByAuditStatus(status);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/search")
    public Result search(@RequestParam String title) {
        try {
            List<MovieBook> list = movieBookService.search(title);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("搜索失败：" + e.getMessage());
        }
    }

    @GetMapping("/hot")
    public Result getHot(@RequestParam(defaultValue = "10") Integer limit) {
        try {
            List<MovieBook> list = movieBookService.getHot(limit);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody MovieBook movieBook) {
        try {
            int result = movieBookService.update(movieBook);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("更新失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = movieBookService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }

    @PutMapping("/audit/pass/{id}")
    public Result auditPass(@PathVariable Integer id) {
        try {
            int result = movieBookService.auditPass(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("审核失败：" + e.getMessage());
        }
    }

    @PutMapping("/audit/reject/{id}")
    public Result auditReject(@PathVariable Integer id) {
        try {
            int result = movieBookService.auditReject(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("审核失败：" + e.getMessage());
        }
    }

    @GetMapping("/search/proc")
    public Result searchWithProc(@RequestParam String keyword) {
        try {
            List<MovieBook> list = movieBookService.searchWithProc(keyword);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("搜索失败：" + e.getMessage());
        }
    }

    @GetMapping("/hot/proc")
    public Result getHotWithProc(@RequestParam(defaultValue = "50") Integer limit) {
        try {
            List<MovieBook> list = movieBookService.getHotWithProc(limit);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @PutMapping("/audit/pass/proc/{id}")
    public Result auditPassWithProc(@PathVariable Integer id) {
        try {
            int result = movieBookService.auditPassWithProc(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("审核失败：" + e.getMessage());
        }
    }

    @PutMapping("/audit/reject/proc/{id}")
    public Result auditRejectWithProc(@PathVariable Integer id) {
        try {
            int result = movieBookService.auditRejectWithProc(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("审核失败：" + e.getMessage());
        }
    }

    @GetMapping("/approved")
    public Result getAllApproved() {
        try {
            List<MovieBook> list = movieBookService.getAllApproved();
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/detail/{id}")
    public Result getDetailById(@PathVariable Integer id) {
        try {
            MovieBook movieBook = movieBookService.getDetailById(id);
            return Result.success(movieBook);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/detail/all")
    public Result getAllDetail() {
        try {
            List<MovieBook> list = movieBookService.getAllDetail();
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }
}