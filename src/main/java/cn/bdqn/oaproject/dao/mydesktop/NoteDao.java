package cn.bdqn.oaproject.dao.mydesktop;

import cn.bdqn.oaproject.pojo.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 我的便签数据操作
 */
@Repository
public interface NoteDao extends JpaRepository<Note,Integer> {
    /**
     * 根据用户编号查询所有便签对象
     * @param creator 创建者
     * @return 便签的List集合
     */
    @Query("select n from Note n where n.creator = ?1")
    List<Note> findByCreator(Integer creator);

    /**
     * 添加便签信息
     * @param s 待添加的便签信息
     */
    @Override
    <S extends Note> S save(S s);
    /**
     * 修改便签信息
     * @param note 待修改的便签信息
     */
    @Modifying
    @Query("update Note n set n.noteTitle = ?1,n.content = ?2,n.mender=?3,n.modifyDate=?4 where n.noteId=?5")
    void modifyNoteInfo(Note note);

    /**
     * 根据便签ID显示便签对象
     * @param noteId 便签标题
     * @return 便签的List集合
     */
    @Query("select n from Note n where n.noteId=?1")
    List<Note> findInfoByNoteId(Integer noteId);

    /**
     * 删除便签信息
     * @param noteId 待删除的便签信息
     */
    @Override
    void deleteById(Integer noteId);
}
