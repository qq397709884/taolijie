package com.fh.taolijie.service.quest;

import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.constant.quest.RequestStatus;
import com.fh.taolijie.domain.quest.FinishRequestModel;
import com.fh.taolijie.exception.checked.GeneralCheckedException;
import com.fh.taolijie.exception.checked.HackException;
import com.fh.taolijie.exception.checked.acc.CashAccNotExistsException;
import com.fh.taolijie.exception.checked.quest.*;

/**
 * 任务提交审核业务接口
 * Created by whf on 9/22/15.
 */
public interface QuestFinishService {
    /**
     * 提交任务完成申请
     * @param model
     */
    void submitRequest(FinishRequestModel model)
            throws GeneralCheckedException;

    /**
     * 更新审核状态
     * @param requestId
     * @param status
     * @param memo
     */
    void updateStatus(Integer requestId, RequestStatus status, String memo)
            throws CashAccNotExistsException, RequestNotExistException, RequestCannotChangeException, AuditNotEnoughException, NotEnoughCouponException, HackException;

    /**
     * 查询所有请求
     * @param pn
     * @param ps
     * @return
     */
    ListResult<FinishRequestModel> findAll(int pn, int ps);

    /**
     * 查询任务提交记录, 按任务id分组, 并执行COUNT(*)
     * @param empId
     * @param pn
     * @param ps
     * @return
     */
    ListResult<FinishRequestModel> findGroupByQuest(Integer empId, int pn, int ps);

    /**
     * 根据状态查询请求
     * @param status
     * @param pn
     * @param ps
     * @return
     */
    ListResult<FinishRequestModel> findByStatus(RequestStatus status, int pn, int ps);

    /**
     * 查询指定用户的申请
     * @return
     */
    ListResult<FinishRequestModel> findByMember(Integer memId, int pn, int ps);

    /**
     * 查询指定用户指定状态的申请
     * @param memId
     * @param status
     * @param pn
     * @param ps
     * @return
     */
    ListResult<FinishRequestModel> findByMember(Integer memId, RequestStatus status, int pn, int ps);

    /**
     * 根据任务查询申请
     * @param questId
     * @return
     */
    ListResult<FinishRequestModel> findByQuest(Integer questId, RequestStatus status, int pn, int ps);

    FinishRequestModel findById(Integer reqId);
}
