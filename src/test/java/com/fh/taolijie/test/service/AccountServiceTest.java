package com.fh.taolijie.test.service;

import com.fh.taolijie.controller.dto.StudentDto;
import com.fh.taolijie.domain.MemberEntity;
import com.fh.taolijie.domain.MemberRoleEntity;
import com.fh.taolijie.domain.RoleEntity;
import com.fh.taolijie.exception.checked.DuplicatedUsernameException;
import com.fh.taolijie.exception.checked.PasswordIncorrectException;
import com.fh.taolijie.exception.checked.UserNotExistsException;
import com.fh.taolijie.service.AccountService;
import com.fh.taolijie.service.impl.DefaultAccountService;
import com.fh.taolijie.test.BaseDatabaseTestClass;
import com.fh.taolijie.utils.Print;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by wanghongfei on 15-3-5.
 */
@ContextConfiguration(classes = {DefaultAccountService.class})
public class AccountServiceTest extends BaseDatabaseTestClass {
    private MemberEntity member;
    private RoleEntity role;

    @Autowired
    private AccountService accService;

    @PersistenceContext
    private EntityManager em;

    @Before
    @Transactional(readOnly = false)
    public void initData() {
        Print.print("准备数据");

        // 创建用户
        // password is 111111
        member = new MemberEntity("Bruce", "3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d", "", "Neo", "", "", "", "", "", "", 20, "", "");
        em.persist(member);

        // 创建role
        role = new RoleEntity("ADMIN", "");
        em.persist(role);

        // 创建关联关系
        MemberRoleEntity memRole = new MemberRoleEntity();
        memRole.setRole(role);
        memRole.setMember(member);
        em.persist(memRole);

        List<MemberRoleEntity> memRoleList = new ArrayList<>();
        memRoleList.add(memRole);
        member.setMemberRoleCollection(memRoleList);
    }

    @Test
    @Transactional(readOnly = false)
    public void testRegisterStudent() {
        StudentDto stuDto = new StudentDto();
        stuDto.setUsername("Hello");
        stuDto.setPassword("222222");
        stuDto.setRoleIdList(Arrays.asList(this.role.getRid()));

        try {
            accService.registerStudent(stuDto);
        } catch (DuplicatedUsernameException e) {
            Print.print(e.getMessage());
            Assert.assertTrue(false);
        }

        // 验证entity是否存在
        MemberEntity mem = em.createQuery("SELECT m FROM MemberEntity m WHERE m.username = :username", MemberEntity.class)
                .setParameter("username", "Hello")
                .getSingleResult();

        // 验证role是否指定
        Collection<MemberRoleEntity> memRoleCollection = mem.getMemberRoleCollection();
        Assert.assertNotNull(memRoleCollection);
        Assert.assertEquals(1, memRoleCollection.size());

        // 验证指定的role是否正确
        Print.print("~~~~~~~~~~~~~~~ id:" + role.getRid() + ", role:" + role.getRolename());
        List<MemberRoleEntity> memRoleList = new ArrayList<>(memRoleCollection);
        boolean contains = memRoleList.get(0).getRole().equals(this.role);
        Assert.assertTrue(contains);
    }

    @Test
    @Transactional(readOnly = false)
    public void testRegisterStudentDuplicatesName() {
        StudentDto stuDto = new StudentDto();
        stuDto.setUsername("Bruce");
        stuDto.setPassword("222222");

        try {
            accService.registerStudent(stuDto);
        } catch (DuplicatedUsernameException e) {
            Print.print(e.getMessage());
            return;
        }

        Assert.assertTrue(false);
    }

    @Test
    @Transactional(readOnly = false)
    public void testLogin() {
        boolean res = false;
        try {
            res = accService.login("Bruce", "111111");
        } catch (UserNotExistsException e) {
            Assert.assertTrue(false);
        } catch (PasswordIncorrectException e) {
            Assert.assertTrue(false);
        }
        Assert.assertTrue(res);

        // 用户名错误
        res = false;
        try {
            accService.login("Neo", "111111");
        } catch (UserNotExistsException e) {
            res = true;
        } catch (PasswordIncorrectException e) {
            res = false;
        }
        Assert.assertTrue(res);

        // 密码错误
        res = false;
        try {
            accService.login("Bruce", "222");
        } catch (UserNotExistsException e) {
            res = false;
        } catch (PasswordIncorrectException e) {
            res = true;
        }
        Assert.assertTrue(res);
    }
}