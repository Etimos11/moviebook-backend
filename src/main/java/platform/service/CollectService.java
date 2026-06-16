package platform.service;

import platform.entity.Collect;

import java.util.List;

public interface CollectService {
    int add(Collect collect);
    int delete(Integer id);
    int cancel(Integer userId, Integer mbId);
    Collect getById(Integer id);
    List<Collect> getByUserId(Integer userId);
    List<Collect> getByMbId(Integer mbId);
    boolean isCollected(Integer userId, Integer mbId);
}