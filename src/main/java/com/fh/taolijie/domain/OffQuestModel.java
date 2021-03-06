package com.fh.taolijie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

public class OffQuestModel extends Pageable {
    private Integer id;

    private Integer memId;

    private String username;

    private String title;

    private Integer cateId;

    private String cateName;

    private BigDecimal award;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date workTime;

    private String workPlace;

    private String description;

    private String contactPhone;

    private String status;

    private Integer provinceId;

    private Integer cityId;

    private Integer regionId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flushTime;


    @JsonIgnore
    private BigDecimal longitude;
    @JsonIgnore
    private BigDecimal latitude;
    //@JsonIgnore
    private Integer distance;

    public OffQuestModel() {}

    public OffQuestModel(int pn, int ps) {
        super(pn, ps);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.id
     *
     * @return the value of off_quest.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.id
     *
     * @param id the value for off_quest.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.mem_id
     *
     * @return the value of off_quest.mem_id
     *
     * @mbggenerated
     */
    public Integer getMemId() {
        return memId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.mem_id
     *
     * @param memId the value for off_quest.mem_id
     *
     * @mbggenerated
     */
    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.username
     *
     * @return the value of off_quest.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.username
     *
     * @param username the value for off_quest.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.title
     *
     * @return the value of off_quest.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.title
     *
     * @param title the value for off_quest.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.cate_id
     *
     * @return the value of off_quest.cate_id
     *
     * @mbggenerated
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.cate_id
     *
     * @param cateId the value for off_quest.cate_id
     *
     * @mbggenerated
     */
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.cate_name
     *
     * @return the value of off_quest.cate_name
     *
     * @mbggenerated
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.cate_name
     *
     * @param cateName the value for off_quest.cate_name
     *
     * @mbggenerated
     */
    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.award
     *
     * @return the value of off_quest.award
     *
     * @mbggenerated
     */
    public BigDecimal getAward() {
        return award;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.award
     *
     * @param award the value for off_quest.award
     *
     * @mbggenerated
     */
    public void setAward(BigDecimal award) {
        this.award = award;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.created_time
     *
     * @return the value of off_quest.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.created_time
     *
     * @param createdTime the value for off_quest.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.work_time
     *
     * @return the value of off_quest.work_time
     *
     * @mbggenerated
     */
    public Date getWorkTime() {
        return workTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.work_time
     *
     * @param workTime the value for off_quest.work_time
     *
     * @mbggenerated
     */
    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.work_place
     *
     * @return the value of off_quest.work_place
     *
     * @mbggenerated
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.work_place
     *
     * @param workPlace the value for off_quest.work_place
     *
     * @mbggenerated
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.description
     *
     * @return the value of off_quest.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.description
     *
     * @param description the value for off_quest.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.contact_phone
     *
     * @return the value of off_quest.contact_phone
     *
     * @mbggenerated
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.contact_phone
     *
     * @param contactPhone the value for off_quest.contact_phone
     *
     * @mbggenerated
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.status
     *
     * @return the value of off_quest.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.status
     *
     * @param status the value for off_quest.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.province_id
     *
     * @return the value of off_quest.province_id
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.province_id
     *
     * @param provinceId the value for off_quest.province_id
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.city_id
     *
     * @return the value of off_quest.city_id
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.city_id
     *
     * @param cityId the value for off_quest.city_id
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column off_quest.region_id
     *
     * @return the value of off_quest.region_id
     *
     * @mbggenerated
     */
    public Integer getRegionId() {
        return regionId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Date getFlushTime() {
        return flushTime;
    }

    public void setFlushTime(Date flushTime) {
        this.flushTime = flushTime;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column off_quest.region_id
     *
     * @param regionId the value for off_quest.region_id
     *
     * @mbggenerated
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}