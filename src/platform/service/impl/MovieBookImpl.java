package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.entity.MovieBook;
import platform.mapper.MovieBookMapper;
import platform.service.MovieBookService;

import java.util.List;

@Service
public class MovieBookImpl implements MovieBookService {

    @Autowired
    private MovieBookMapper movieBookMapper;

    @Override
    public int add(MovieBook movieBook) {
        return movieBookMapper.insert(movieBook);
    }

    @Override
    public MovieBook getById(Integer id) {
        return movieBookMapper.selectById(id);
    }

    @Override
    public List<MovieBook> getByType(Integer type) {
        return movieBookMapper.selectByType(type);
    }

    @Override
    public List<MovieBook> getByCategory(Integer categoryId) {
        return movieBookMapper.selectByCategory(categoryId);
    }

    @Override
    public List<MovieBook> getByAuditStatus(Integer auditStatus) {
        return movieBookMapper.selectByAuditStatus(auditStatus);
    }

    @Override
    public List<MovieBook> search(String title) {
        return movieBookMapper.searchByTitle(title);
    }

    @Override
    public List<MovieBook> getHot(Integer limit) {
        return movieBookMapper.selectHot(limit);
    }

    @Override
    public int update(MovieBook movieBook) {
        return movieBookMapper.update(movieBook);
    }

    @Override
    public int delete(Integer id) {
        return movieBookMapper.delete(id);
    }

    @Override
    public int auditPass(Integer id) {
        return movieBookMapper.updateAuditStatus(id, 1);
    }

    @Override
    public int auditReject(Integer id) {
        return movieBookMapper.updateAuditStatus(id, 2);
    }

    @Override
    public List<MovieBook> searchWithProc(String keyword) {
        return movieBookMapper.searchByTitleWithProc(keyword);
    }

    @Override
    public List<MovieBook> getHotWithProc(Integer limit) {
        return movieBookMapper.selectHotWithProc(limit);
    }

    @Override
    public int auditPassWithProc(Integer id) {
        return movieBookMapper.auditPassWithProc(id);
    }

    @Override
    public int auditRejectWithProc(Integer id) {
        return movieBookMapper.auditRejectWithProc(id);
    }

    @Override
    public List<MovieBook> getAllApproved() {
        return movieBookMapper.selectAllApproved();
    }

    @Override
    public MovieBook getDetailById(Integer id) {
        return movieBookMapper.selectDetailById(id);
    }

    @Override
    public List<MovieBook> getAllDetail() {
        return movieBookMapper.selectAllDetail();
    }


    // 在 platform.service.impl 对应的实现类中重写该接口：
    @Override
    public java.util.Map<String, Object> getStatsOverview() {
        return movieBookMapper.selectStatsOverview();
    }

    @Override
    public int recalculateScoreAndHot(Integer id) {
        return movieBookMapper.recalculateScoreAndHot(id);
    }

}