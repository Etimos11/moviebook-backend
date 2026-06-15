package platform.service;

import platform.entity.MovieBook;

import java.util.List;

public interface MovieBookService {
    int add(MovieBook movieBook);
    MovieBook getById(Integer id);
    List<MovieBook> getByType(Integer type);
    List<MovieBook> getByCategory(Integer categoryId);
    List<MovieBook> getByAuditStatus(Integer auditStatus);
    List<MovieBook> search(String title);
    List<MovieBook> getHot(Integer limit);
    int update(MovieBook movieBook);
    int delete(Integer id);
    int auditPass(Integer id);
    int auditReject(Integer id);
    
    List<MovieBook> searchWithProc(String keyword);
    List<MovieBook> getHotWithProc(Integer limit);
    int auditPassWithProc(Integer id);
    int auditRejectWithProc(Integer id);
    
    List<MovieBook> getAllApproved();
    MovieBook getDetailById(Integer id);
    List<MovieBook> getAllDetail();

    // 在您的 platform.service.MovieBookService 接口类中添加如下签名：
    java.util.Map<String, Object> getStatsOverview();

    int recalculateScoreAndHot(Integer id);
}