package cn.bdqn.oaproject.service.mydesktop;

import cn.bdqn.oaproject.pojo.Note;

import java.util.List;

/**
 * 我的便签业务操作接口
 */
public interface NoteService {

    /**
     * 根据用户编号查询所有便签对象
     * @param creator 创建者
     * @return 便签对象集合
     */
    List<Note> getInfoByCreator(Integer creator);

    /**
     * 添加便签信息
     * @param note 便签信息
     * @return 是否成功
     */
    boolean addInfo(Note note);

    /**
     * 修改便签信息
     * @param note 便签信息
     * @return 是否成功
     */
    boolean updateInfo(Note note);

    /**
     * 根据便签ID获取便签对象
     * @param noteId 便签Id
     * @return 便签对象集合
     */
    List<Note> getInfoByNoteId(Integer noteId);

    /**
     * 根据Id删除信息
     * @param noteId 便签Id
     * @return 是否成功
     */
    boolean deleteInfo(Integer noteId);
}
