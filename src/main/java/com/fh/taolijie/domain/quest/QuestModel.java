package com.fh.taolijie.domain.quest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.domain.Pageable;
import com.fh.taolijie.service.prop.IdAware;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class QuestModel extends Pageable implements IdAware {
    private Integer id;

    @NotNull
    private String title;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flushTime;

    @NotNull
    private Integer questCateId;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Null
    private Integer limitTime;

    @NotNull
    private Integer totalAmt;

    @Null
    private Integer leftAmt;

    @NotNull
    private BigDecimal award;

    @Null
    private Integer memberId;

    @Null
    private BigDecimal finalAward;

    @NotNull
    private String contactName;

    @NotNull
    private String contactPhone;

    @NotNull
    private String description;

    @NotNull
    private String questDetail;

    private String url;

    private String memo;

    private Boolean offline;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tagExpireTime;

    private Integer questionAmt;

    private Boolean coupon;

    private Integer couponLeft;

    private Integer couponTot;

    private Boolean isTargetAll;

    /**
     * 商家在我的发布中看到的状态
     */
    @Null
    private Integer empStatus;

    // ********* 查询使用 ***********
    @JsonIgnore
    private Integer provinceId;
    @JsonIgnore
    private Integer cityId;
    @JsonIgnore
    private Integer regionId;

    @JsonIgnore
    private Integer collegeId;
    @JsonIgnore
    private Integer schoolId;
    @JsonIgnore
    private Boolean ended = false;
    // ********* 查询使用 ***********

    // 以下只作为返回值使用
    private List<QuestSchRelModel> schools;
    private List<QuestCollRelModel> colleges;
    private List<QuestCiRel> cities;
    private List<QuestProRel> pros;
    // 以上只作为返回值使用


    // ******** 仅作为请求参数使用 ********

    @JsonIgnore
    private Boolean awardRangeQuery = false;
    @JsonIgnore
    private BigDecimal minAward;
    @JsonIgnore
    private BigDecimal maxAward;


    @JsonIgnore
    private List<Integer> collegeIdList;
    @JsonIgnore
    private List<Integer> schoolIdList;
    @JsonIgnore
    private List<Integer> cityIdList;
    @JsonIgnore
    private List<Integer> provinceIdList;

    // ******** 仅作为请求参数使用 ********


    // ******** 仅返回用 ********

    /**
     * 该任务对于当前用户的状态
     */
    private Integer status;

    // ******** 仅返回用 ********

    public QuestModel() {}

    public QuestModel(int pn, int ps) {
        super(pn, ps);
    }

    public static boolean validate(QuestModel model) {
        // 只要有一个字段为null就返回false
        return !(null == model.title
                || null == model.questCateId
                || null == model.startTime
                || null == model.endTime
                || null == model.totalAmt
                || null == model.award
                || null == model.contactName
                || null == model.contactPhone
                || null == model.description
                || null == model.questDetail
                || null == model.provinceId
                || null == model.cityId
                || null == model.regionId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Boolean getCoupon() {
        return coupon;
    }

    public void setCoupon(Boolean coupon) {
        this.coupon = coupon;
    }

    public Integer getCouponLeft() {
        return couponLeft;
    }

    public void setCouponLeft(Integer couponLeft) {
        this.couponLeft = couponLeft;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getQuestCateId() {
        return questCateId;
    }

    public void setQuestCateId(Integer questCateId) {
        this.questCateId = questCateId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.total_amt
     *
     * @return the value of quest.total_amt
     *
     * @mbggenerated
     */
    public Integer getTotalAmt() {
        return totalAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.total_amt
     *
     * @param totalAmt the value for quest.total_amt
     *
     * @mbggenerated
     */
    public void setTotalAmt(Integer totalAmt) {
        this.totalAmt = totalAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.left_amt
     *
     * @return the value of quest.left_amt
     *
     * @mbggenerated
     */
    public Integer getLeftAmt() {
        return leftAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.left_amt
     *
     * @param leftAmt the value for quest.left_amt
     *
     * @mbggenerated
     */
    public void setLeftAmt(Integer leftAmt) {
        this.leftAmt = leftAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.award
     *
     * @return the value of quest.award
     *
     * @mbggenerated
     */
    public BigDecimal getAward() {
        return award;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.award
     *
     * @param award the value for quest.award
     *
     * @mbggenerated
     */
    public void setAward(BigDecimal award) {
        this.award = award;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.contact_name
     *
     * @return the value of quest.contact_name
     *
     * @mbggenerated
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.contact_name
     *
     * @param contactName the value for quest.contact_name
     *
     * @mbggenerated
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.contact_phone
     *
     * @return the value of quest.contact_phone
     *
     * @mbggenerated
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.contact_phone
     *
     * @param contactPhone the value for quest.contact_phone
     *
     * @mbggenerated
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.description
     *
     * @return the value of quest.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.description
     *
     * @param description the value for quest.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.quest_detail
     *
     * @return the value of quest.quest_detail
     *
     * @mbggenerated
     */
    public String getQuestDetail() {
        return questDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.quest_detail
     *
     * @param questDetail the value for quest.quest_detail
     *
     * @mbggenerated
     */
    public void setQuestDetail(String questDetail) {
        this.questDetail = questDetail == null ? null : questDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.url
     *
     * @return the value of quest.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.url
     *
     * @param url the value for quest.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.memo
     *
     * @return the value of quest.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest.memo
     *
     * @param memo the value for quest.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest.offline
     *
     * @return the value of quest.offline
     *
     * @mbggenerated
     */
    public Boolean getOffline() {
        return offline;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public BigDecimal getFinalAward() {
        return finalAward;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setFinalAward(BigDecimal finalAward) {
        this.finalAward = finalAward;
    }

    public Boolean getAwardRangeQuery() {
        return awardRangeQuery;
    }

    public void setAwardRangeQuery(Boolean awardRangeQuery) {
        this.awardRangeQuery = awardRangeQuery;
    }

    public BigDecimal getMinAward() {
        return minAward;
    }

    public void setMinAward(BigDecimal minAward) {
        this.minAward = minAward;
    }

    public BigDecimal getMaxAward() {
        return maxAward;
    }

    public void setMaxAward(BigDecimal maxAward) {
        this.maxAward = maxAward;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getCollegeIdList() {
        return collegeIdList;
    }

    public void setCollegeIdList(List<Integer> collegeIdList) {
        this.collegeIdList = collegeIdList;
    }

    public List<Integer> getSchoolIdList() {
        return schoolIdList;
    }

    public void setSchoolIdList(List<Integer> schoolIdList) {
        this.schoolIdList = schoolIdList;
    }

    public Integer getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(Integer empStatus) {
        this.empStatus = empStatus;
    }

    public Date getTagExpireTime() {
        return tagExpireTime;
    }

    public void setTagExpireTime(Date tagExpireTime) {
        this.tagExpireTime = tagExpireTime;
    }

    public Integer getQuestionAmt() {
        return questionAmt;
    }

    public void setQuestionAmt(Integer questionAmt) {
        this.questionAmt = questionAmt;
    }

    public Date getFlushTime() {
        return flushTime;
    }

    public void setFlushTime(Date flushTime) {
        this.flushTime = flushTime;
    }

    public List<Integer> getCityIdList() {
        return cityIdList;
    }

    public List<QuestSchRelModel> getSchools() {
        return schools;
    }

    public void setSchools(List<QuestSchRelModel> schools) {
        this.schools = schools;
    }

    public List<QuestCollRelModel> getColleges() {
        return colleges;
    }

    public void setColleges(List<QuestCollRelModel> colleges) {
        this.colleges = colleges;
    }

    public List<QuestCiRel> getCities() {
        return cities;
    }

    public void setCities(List<QuestCiRel> cities) {
        this.cities = cities;
    }

    public List<QuestProRel> getPros() {
        return pros;
    }

    public void setPros(List<QuestProRel> pros) {
        this.pros = pros;
    }

    public void setCityIdList(List<Integer> cityIdList) {
        this.cityIdList = cityIdList;
    }

    public List<Integer> getProvinceIdList() {
        return provinceIdList;
    }

    public void setProvinceIdList(List<Integer> provinceIdList) {
        this.provinceIdList = provinceIdList;
    }

    public Integer getCouponTot() {
        return couponTot;
    }

    public void setCouponTot(Integer couponTot) {
        this.couponTot = couponTot;
    }

    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    public Boolean getIsTargetAll() {
        return isTargetAll;
    }


    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    public void setIsTargetAll(Boolean isTargetAll) {
        this.isTargetAll = isTargetAll;
    }
}