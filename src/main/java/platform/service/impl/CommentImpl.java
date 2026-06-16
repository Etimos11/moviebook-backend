package platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.entity.Comment;
import platform.entity.Note;
import platform.mapper.CommentMapper;
import platform.mapper.NoteMapper;
import platform.mapper.MovieBookMapper;
import platform.service.CommentService;

import java.util.List;

@Service
public class CommentImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private MovieBookMapper movieBookMapper;

    @Override
    @Transactional
    public int add(Comment comment) {
        int result = commentMapper.insert(comment);
        Note note = noteMapper.selectById(comment.getNoteId());
        if (note != null && note.getMbId() != null) {
            movieBookMapper.recalculateScoreAndHot(note.getMbId());
        }
        return result;
    }

    @Override
    @Transactional
    public int update(Comment comment) {
        return commentMapper.update(comment);
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        Comment comment = commentMapper.selectById(id);
        if (comment != null) {
            int result = commentMapper.delete(id);
            Note note = noteMapper.selectById(comment.getNoteId());
            if (note != null && note.getMbId() != null) {
                movieBookMapper.recalculateScoreAndHot(note.getMbId());
            }
            return result;
        }
        return 0;
    }

    @Override
    public Comment getById(Integer id) {
        return commentMapper.selectById(id);
    }

    @Override
    public List<Comment> getByUserId(Integer userId) {
        return commentMapper.selectByUserId(userId);
    }

    @Override
    public List<Comment> getByNoteId(Integer noteId) {
        return commentMapper.selectByNoteId(noteId);
    }
}