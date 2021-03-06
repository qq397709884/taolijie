package com.fh.taolijie.domain.certi;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fh.taolijie.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class StuCertiModel extends Pageable {
    private Integer id;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer memberId;

    private String username;

    private String name;

    private Integer cityId;

    private Integer collegeId;

    private Integer schoolId;

    private String clazz;

    private String picIds;

    private String status;

    private String memo;

    public StuCertiModel() {}
    public StuCertiModel(int pn, int ps) {
        super(pn, ps);
    }

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.id
     *
     * @param id the value for stu_certi.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.created_time
     *
     * @return the value of stu_certi.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.created_time
     *
     * @param createdTime the value for stu_certi.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.update_time
     *
     * @return the value of stu_certi.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.update_time
     *
     * @param updateTime the value for stu_certi.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.member_id
     *
     * @return the value of stu_certi.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.member_id
     *
     * @param memberId the value for stu_certi.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.name
     *
     * @return the value of stu_certi.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.name
     *
     * @param name the value for stu_certi.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.college_id
     *
     * @return the value of stu_certi.college_id
     *
     * @mbggenerated
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.college_id
     *
     * @param collegeId the value for stu_certi.college_id
     *
     * @mbggenerated
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.school_id
     *
     * @return the value of stu_certi.school_id
     *
     * @mbggenerated
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.school_id
     *
     * @param schoolId the value for stu_certi.school_id
     *
     * @mbggenerated
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.clazz
     *
     * @return the value of stu_certi.clazz
     *
     * @mbggenerated
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.clazz
     *
     * @param clazz the value for stu_certi.clazz
     *
     * @mbggenerated
     */
    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.pic_ids
     *
     * @return the value of stu_certi.pic_ids
     *
     * @mbggenerated
     */
    public String getPicIds() {
        return picIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.pic_ids
     *
     * @param picIds the value for stu_certi.pic_ids
     *
     * @mbggenerated
     */
    public void setPicIds(String picIds) {
        this.picIds = picIds == null ? null : picIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.status
     *
     * @return the value of stu_certi.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu_certi.status
     *
     * @param status the value for stu_certi.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu_certi.memo
     *
     * @return the value of stu_certi.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}