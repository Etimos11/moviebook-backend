package platform.mapper;

import platform.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CollectMapper {
    int insert(Collect collect);
    Collect selectById(Integer id);
    Collect selectByUserMb(@Param("userId") Integer userId, @Param("mbId") Integer mbId);
    List<Collect> selectByUserId(@Param("userId") Integer userId);
    List<Collect> selectByMbId(@Param("mbId") Integer mbId);
    int delete(Integer id);
    int deleteByUserMb(@Param("userId") Integer userId, @Param("mbId") Integer mbId);
}