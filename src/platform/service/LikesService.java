package platform.service;

import platform.entity.Likes;

import java.util.List;

public interface LikesService {
    int add(Likes likes);
    int delete(Integer id);
    int cancel(Integer userId, Integer noteId);
    Likes getById(Integer id);
    List<Likes> getByUserId(Integer userId);
    List<Likes> getByNoteId(Integer noteId);
    boolean isLiked(Integer userId, Integer noteId);
}