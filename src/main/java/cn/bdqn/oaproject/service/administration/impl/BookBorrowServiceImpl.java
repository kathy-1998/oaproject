package cn.bdqn.oaproject.service.administration.impl;

import cn.bdqn.oaproject.dao.administration.BookBorrowDao;
import cn.bdqn.oaproject.pojo.BookBorrow;
import cn.bdqn.oaproject.pojo.WaitingTaskRecord;
import cn.bdqn.oaproject.service.administration.BookBorrowService;
import cn.bdqn.oaproject.service.mydesktop.WaitingTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 图书借阅申请业务操作接口
 */

@Service("bookBorrowService")
@Transactional
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    BookBorrowDao bookBorrowDao;

    @Autowired
    WaitingTaskRecordService waitingTaskRecordService;


    @Override
    public boolean Add(BookBorrow bookBorrow) {
           try {
               bookBorrowDao.save(bookBorrow);

               //并向待处理任务中添加一条
               WaitingTaskRecord waitingTaskRecord=new WaitingTaskRecord();

               waitingTaskRecord.setWaitingTaskRecordName(bookBorrow.getBorrowUserName()+"图书借阅申请"); //任务名称
               waitingTaskRecord.setTaskTypeId(bookBorrow.getTaskTypeId());  //任务类型
               waitingTaskRecord.setApplyId(bookBorrow.getTaskTypeId()); //申请记录id
               waitingTaskRecord.setApplyTime(bookBorrow.getCreationDate()); //申请时间
               waitingTaskRecord.setIsdelete(1);   //是否删除,默认1
               waitingTaskRecord.setInitiatorId(bookBorrow.getBorrowUserId());    //申请人
               waitingTaskRecord.setUserId(bookBorrow.getUserId());  //审批人
               waitingTaskRecord.setStatus(bookBorrow.getStatus());  //状态
               waitingTaskRecord.setCreationDate(new Date());  //任务创建时间
               waitingTaskRecord.setCreator(bookBorrow.getBookBorrowId());
               waitingTaskRecordService.addInfo(waitingTaskRecord);


               return  true;
           }catch (Exception e){
               e.printStackTrace();
               return  false;
           }
    }
}
