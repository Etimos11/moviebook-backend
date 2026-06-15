package platform.mapper;

import platform.entity.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NoteMapper {
    int insert(Note note);
    Note selectById(Integer id);
    List<Note> selectByUserId(@Param("userId") Integer userId);
    List<Note> selectByMbId(@Param("mbId") Integer mbId);
    int update(Note note);
    int delete(Integer id);
}