package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.entity.Note;
import platform.mapper.NoteMapper;
import platform.mapper.CommentMapper;
import platform.mapper.LikesMapper;
import platform.mapper.MovieBookMapper;
import platform.service.NoteService;

import java.util.List;

@Service
public class NoteImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private MovieBookMapper movieBookMapper;

    @Override
    @Transactional // 开启事务
    public int add(Note note) {
        int result = noteMapper.insert(note);
        if (note.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(note.getMbId());
        }
        return result;
    }

    @Override
    public Note getById(Integer id) {
        return noteMapper.selectById(id);
    }

    @Override
    public List<Note> getByUserId(Integer userId) {
        return noteMapper.selectByUserId(userId);
    }

    @Override
    public List<Note> getByMbId(Integer mbId) {
        return noteMapper.selectByMbId(mbId);
    }

    @Override
    public List<Note> getAll() {
        return noteMapper.selectAll();
    }

    @Override
    @Transactional
    public int update(Note note) {
        int result = noteMapper.update(note);
        if (note.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(note.getMbId());
        }
        return result;
    }

    @Override
    @Transactional // 💡 卓越核心：完美断绝关联点赞及随笔评，完美级联熔毁并实时重算影视权重
    public int delete(Integer id) {
        Note note = noteMapper.selectById(id);
        if (note == null) return 0;

        Integer mbId = note.getMbId();

        // 1. 先安全物理拆除该文章的所有点赞关联记录
        likesMapper.deleteByNoteId(id);

        // 2. 安全删除该文章所有附属留言论记录
        commentMapper.deleteByNoteId(id);

        // 3. 扫尾清空文章本身，此时已没有任何外键冲突，100% 删除成功！
        int result = noteMapper.delete(id);

        // 4. 重算该书本热度与评分
        if (mbId != null) {
            movieBookMapper.recalculateScoreAndHot(mbId);
        }

        return result;
    }


}