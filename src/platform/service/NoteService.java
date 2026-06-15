package platform.service;

import platform.entity.Note;

import java.util.List;

public interface NoteService {
    int add(Note note);
    Note getById(Integer id);
    List<Note> getByUserId(Integer userId);
    List<Note> getByMbId(Integer mbId);
    int update(Note note);
    int delete(Integer id);
}