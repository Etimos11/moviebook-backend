package platform.mapper;

import platform.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CommentMapper {
    int insert(Comment comment);
    Comment selectById(Integer id);
    List<Comment> selectByUserId(@Param("userId") Integer userId);
    List<Comment> selectByNoteId(@Param("noteId") Integer noteId);
    int update(Comment comment);
    int delete(Integer id);
    int deleteByNoteId(@Param("noteId") Integer noteId);
}