package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.entity.Collect;
import platform.mapper.CollectMapper;
import platform.mapper.MovieBookMapper;
import platform.service.CollectService;

import java.util.List;

@Service
public class CollectImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private MovieBookMapper movieBookMapper;

    @Override
    @Transactional
    public int add(Collect collect) {
        int result = collectMapper.insert(collect);
        if (collect.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(collect.getMbId());
        }
        return result;
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        Collect collect = collectMapper.selectById(id);
        if (collect != null) {
            int result = collectMapper.delete(id);
            if (collect.getMbId() != null) {
                movieBookMapper.recalculateScoreAndHot(collect.getMbId());
            }
            return result;
        }
        return 0;
    }

    @Override
    @Transactional
    public int cancel(Integer userId, Integer mbId) {
        int result = collectMapper.deleteByUserMb(userId, mbId);
        movieBookMapper.recalculateScoreAndHot(mbId);
        return result;
    }

    @Override
    public Collect getById(Integer id) {
        return collectMapper.selectById(id);
    }

    @Override
    public List<Collect> getByUserId(Integer userId) {
        return collectMapper.selectByUserId(userId);
    }

    @Override
    public List<Collect> getByMbId(Integer mbId) {
        return collectMapper.selectByMbId(mbId);
    }

    @Override
    public boolean isCollected(Integer userId, Integer mbId) {
        Collect collect = collectMapper.selectByUserMb(userId, mbId);
        return collect != null;
    }
}