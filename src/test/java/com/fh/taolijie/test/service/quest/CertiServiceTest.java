package com.fh.taolijie.test.service.quest;

import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.constant.certi.CertiStatus;
import com.fh.taolijie.dao.mapper.EmpCertiModelMapper;
import com.fh.taolijie.dao.mapper.MemberModelMapper;
import com.fh.taolijie.domain.certi.EmpCertiModel;
import com.fh.taolijie.domain.acc.MemberModel;
import com.fh.taolijie.service.certi.EmpCertiService;
import com.fh.taolijie.service.certi.impl.DefaultEmpCertiService;
import com.fh.taolijie.test.BaseSpringDataTestClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by whf on 9/22/15.
 */
@ContextConfiguration(classes = {
        DefaultEmpCertiService.class
})
public class CertiServiceTest extends BaseSpringDataTestClass {
    @Autowired
    private EmpCertiService empService;

    @Autowired
    EmpCertiModelMapper empMapper;

    @Autowired
    MemberModelMapper memMapper;


    @Test
    //@Rollback(false)
    public void testEmpApply() {
        EmpCertiModel model = new EmpCertiModel();
        model.setMemberId(1);
        model.setAddress("Earth");
        model.setCompanyName("Microsoft");

        empService.addApplication(model);
    }

    @Test
    public void testUpdateStatus() {
        empService.updateStatus(5, 1, CertiStatus.DONE, "ok");

        EmpCertiModel emp = empMapper.selectByPrimaryKey(5);
        Assert.assertEquals(CertiStatus.DONE.code(), emp.getStatus());


        MemberModel m = memMapper.selectByPrimaryKey(1);
        Assert.assertEquals(CertiStatus.DONE.code(), m.getIdCerti());
    }

    @Test
    public void testFindEmpByMember() {
        ListResult<EmpCertiModel> lr = empService.findByMember(1);
        Assert.assertFalse(lr.getList().isEmpty());
    }
}
