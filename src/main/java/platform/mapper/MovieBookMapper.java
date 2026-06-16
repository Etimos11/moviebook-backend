package platform.mapper;

import platform.entity.MovieBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MovieBookMapper {
    int insert(MovieBook movieBook);
    MovieBook selectById(Integer id);
    List<MovieBook> selectByType(@Param("type") Integer type);
    List<MovieBook> selectByCategory(@Param("categoryId") Integer categoryId);
    List<MovieBook> selectByAuditStatus(@Param("auditStatus") Integer auditStatus);
    List<MovieBook> searchByTitle(@Param("title") String title);
    List<MovieBook> selectHot(@Param("limit") Integer limit);
    int update(MovieBook movieBook);
    int delete(Integer id);
    int updateAuditStatus(@Param("id") Integer id, @Param("status") Integer status);
    int updateHot(@Param("id") Integer id, @Param("hot") Integer hot);
    int updateScore(@Param("id") Integer id, @Param("score") Double score);

    // 重新平衡计算该作品的最新平均星级(Score)和最新多维融合热度值(Hot)
    int recalculateScoreAndHot(@Param("id") Integer id);
    
    List<MovieBook> searchByTitleWithProc(@Param("keyword") String keyword);
    List<MovieBook> selectHotWithProc(@Param("limit") Integer limit);
    int auditPassWithProc(@Param("id") Integer id);
    int auditRejectWithProc(@Param("id") Integer id);
    
    List<MovieBook> selectAllApproved();
    MovieBook selectDetailById(@Param("id") Integer id);
    List<MovieBook> selectAllDetail();
    // 在您的 platform.mapper.MovieBookMapper 接口类中添加如下签名：
    java.util.Map<String, Object> selectStatsOverview();
}