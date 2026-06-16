package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.Likes;
import platform.service.LikesService;
import platform.util.Result;

import java.util.List;

@RestController
@RequestMapping("/likes")

public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/add")
    public Result add(@RequestBody Likes likes) {
        try {
            int result = likesService.add(likes);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("点赞失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            Likes likes = likesService.getById(id);
            return Result.success(likes);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        try {
            List<Likes> list = likesService.getByUserId(userId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/note/{noteId}")
    public Result getByNoteId(@PathVariable Integer noteId) {
        try {
            List<Likes> list = likesService.getByNoteId(noteId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = likesService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/cancel")
    public Result cancel(@RequestParam Integer userId, @RequestParam Integer noteId) {
        try {
            int result = likesService.cancel(userId, noteId);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("取消点赞失败：" + e.getMessage());
        }
    }

    @GetMapping("/check")
    public Result check(@RequestParam Integer userId, @RequestParam Integer noteId) {
        try {
            boolean isLiked = likesService.isLiked(userId, noteId);
            return Result.success(isLiked);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }
}