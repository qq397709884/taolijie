package com.fh.taolijie.domain;

import java.util.Date;

public class SeQuestionModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.created_time
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.acc_id
     *
     * @mbggenerated
     */
    private Integer accId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column secret_question.answer
     *
     * @mbggenerated
     */
    private String answer;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.id
     *
     * @return the value of secret_question.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.id
     *
     * @param id the value for secret_question.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.created_time
     *
     * @return the value of secret_question.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.created_time
     *
     * @param createdTime the value for secret_question.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.member_id
     *
     * @return the value of secret_question.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.member_id
     *
     * @param memberId the value for secret_question.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.acc_id
     *
     * @return the value of secret_question.acc_id
     *
     * @mbggenerated
     */
    public Integer getAccId() {
        return accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.acc_id
     *
     * @param accId the value for secret_question.acc_id
     *
     * @mbggenerated
     */
    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.content
     *
     * @return the value of secret_question.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.content
     *
     * @param content the value for secret_question.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column secret_question.answer
     *
     * @return the value of secret_question.answer
     *
     * @mbggenerated
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column secret_question.answer
     *
     * @param answer the value for secret_question.answer
     *
     * @mbggenerated
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}