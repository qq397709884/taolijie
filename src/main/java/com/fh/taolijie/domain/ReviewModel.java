package com.fh.taolijie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ReviewModel extends Pageable {
    private Integer id;

    private Integer shPostId;


    /**
     * 评论发布的时间
     */
    private Date time;

    /**
     * 如果这是一条评论的回复，则该值为被回复的评论id
     */
    private Integer repliedReviewId;

    private String content;

    /**
     * 评论的发布者
     */
    private Integer memberId;
    private MemberModel member;

    /**
     * 评论对应的兼职信息
     */
    private Integer jobPostId;
    @JsonIgnore
    private JobPostModel jobPost; // we don't need this field

    public ReviewModel() {}
    public ReviewModel(int pageNumber, int pageSize) {
        super(pageNumber, pageSize);
    }

    public JobPostModel getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPostModel jobPost) {
        this.jobPost = jobPost;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public Integer getShPostId() {
        return shPostId;
    }

    public void setShPostId(Integer shPostId) {
        this.shPostId = shPostId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.id
     *
     * @return the value of review.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.id
     *
     * @param id the value for review.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.post_id
     *
     * @return the value of review.post_id
     *
     * @mbggenerated
     */
    public Integer getJobPostId() {
        return jobPostId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.post_id
     *
     * @param postId the value for review.post_id
     *
     * @mbggenerated
     */
    public void setJobPostId(Integer postId) {
        this.jobPostId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.member_id
     *
     * @return the value of review.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.member_id
     *
     * @param memberId the value for review.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.time
     *
     * @return the value of review.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.time
     *
     * @param time the value for review.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.replied_review_id
     *
     * @return the value of review.replied_review_id
     *
     * @mbggenerated
     */
    public Integer getRepliedReviewId() {
        return repliedReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.replied_review_id
     *
     * @param repliedReviewId the value for review.replied_review_id
     *
     * @mbggenerated
     */
    public void setRepliedReviewId(Integer repliedReviewId) {
        this.repliedReviewId = repliedReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.content
     *
     * @return the value of review.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.content
     *
     * @param content the value for review.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}