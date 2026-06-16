package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.Comment;
import platform.service.CommentService;
import platform.util.Result;

import java.util.List;

@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Result add(@RequestBody Comment comment) {
        try {
            int result = commentService.add(comment);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("添加失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            Comment comment = commentService.getById(id);
            return Result.success(comment);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        try {
            List<Comment> list = commentService.getByUserId(userId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/note/{noteId}")
    public Result getByNoteId(@PathVariable Integer noteId) {
        try {
            List<Comment> list = commentService.getByNoteId(noteId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody Comment comment) {
        try {
            int result = commentService.update(comment);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("更新失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = commentService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }
}