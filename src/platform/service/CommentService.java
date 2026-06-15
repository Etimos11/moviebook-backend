package platform.service;

import platform.entity.Comment;

import java.util.List;

public interface CommentService {
    int add(Comment comment);
    Comment getById(Integer id);
    List<Comment> getByUserId(Integer userId);
    List<Comment> getByNoteId(Integer noteId);
    int update(Comment comment);
    int delete(Integer id);
}