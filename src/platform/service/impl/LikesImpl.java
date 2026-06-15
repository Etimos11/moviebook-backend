package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.entity.Likes;
import platform.entity.Note;
import platform.mapper.LikesMapper;
import platform.mapper.NoteMapper;
import platform.mapper.MovieBookMapper;
import platform.service.LikesService;

import java.util.List;

@Service
public class LikesImpl implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private MovieBookMapper movieBookMapper;

    @Override
    @Transactional
    public int add(Likes likes) {
        int result = likesMapper.insert(likes);
        // 点赞时，获得关联的随笔 Note 实体，从而重置其所属作品的高亮热度
        Note note = noteMapper.selectById(likes.getNoteId());
        if (note != null && note.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(note.getMbId());
        }
        return result;
    }

    @Override
    @Transactional
    public int cancel(Integer userId, Integer noteId) {
        int result = likesMapper.deleteByUserNote(userId, noteId);
        Note note = noteMapper.selectById(noteId);
        if (note != null && note.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(note.getMbId());
        }
        return result;
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        Likes likes = likesMapper.selectById(id);
        if (likes != null) {
            int result = likesMapper.delete(id);
            Note note = noteMapper.selectById(likes.getNoteId());
            if (note != null && note.getMbId() != null) {
                movieBookMapper.recalculateScoreAndHot(note.getMbId());
            }
            return result;
        }
        return 0;
    }

    @Override
    public Likes getById(Integer id) {
        return likesMapper.selectById(id);
    }

    @Override
    public List<Likes> getByUserId(Integer userId) {
        return likesMapper.selectByUserId(userId);
    }

    @Override
    public List<Likes> getByNoteId(Integer noteId) {
        return likesMapper.selectByNoteId(noteId);
    }

    @Override
    public boolean isLiked(Integer userId, Integer noteId) {
        Likes likes = likesMapper.selectByUserNote(userId, noteId);
        return likes != null;
    }
}