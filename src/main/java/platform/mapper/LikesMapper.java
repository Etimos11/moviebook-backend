package platform.mapper;

import platform.entity.Likes;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LikesMapper {
    int insert(Likes likes);
    Likes selectById(Integer id);
    Likes selectByUserNote(@Param("userId") Integer userId, @Param("noteId") Integer noteId);
    List<Likes> selectByUserId(@Param("userId") Integer userId);
    List<Likes> selectByNoteId(@Param("noteId") Integer noteId);
    int delete(Integer id);
    int deleteByUserNote(@Param("userId") Integer userId, @Param("noteId") Integer noteId);
    int deleteByNoteId(@Param("noteId") Integer noteId);
}