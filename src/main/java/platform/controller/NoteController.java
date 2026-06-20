package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.entity.Note;
import platform.service.NoteService;
import platform.util.Result;

import java.util.List;

@RestController
@RequestMapping("/note")

public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public Result add(@RequestBody Note note) {
        try {
            int result = noteService.add(note);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("添加失败：" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        try {
            Note note = noteService.getById(id);
            return Result.success(note);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        try {
            List<Note> list = noteService.getByUserId(userId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/mb/{mbId}")
    public Result getByMbId(@PathVariable Integer mbId) {
        try {
            List<Note> list = noteService.getByMbId(mbId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    @GetMapping("/all")
    public Result getAll() {
        try {
            return Result.success(noteService.getAll());
        } catch (Exception e) {
            return Result.error("获取笔记失败：" + e.getMessage());
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody Note note) {
        try {
            int result = noteService.update(note);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("更新失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            int result = noteService.delete(id);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }
}