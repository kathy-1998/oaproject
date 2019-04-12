package cn.bdqn.oaproject.service.mydesktop.impl;

import cn.bdqn.oaproject.dao.mydesktop.NoteDao;
import cn.bdqn.oaproject.pojo.Note;
import cn.bdqn.oaproject.service.mydesktop.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;
    @Override
    public List<Note> getInfoByCreator(Integer creator) {
        List<Note> list=null;
        try {
            list=noteDao.findByCreator(creator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Note> getInfoByNoteId(Integer noteId) {
        List<Note> list=null;
        try {
            list=noteDao.findInfoByNoteId(noteId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addInfo(Note note) {
        try{
            noteDao.save(note);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean updateInfo(Note note) {
        try{
            noteDao.modifyNoteInfo(note);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteInfo(Integer noteId) {
        try{
            noteDao.deleteById(noteId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
