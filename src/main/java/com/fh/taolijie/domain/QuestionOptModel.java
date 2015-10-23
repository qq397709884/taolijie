package com.fh.taolijie.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class QuestionOptModel {
    private Integer id;

    private String optName;

    private String optContent;

    private Integer questionId;

    private Integer answerAmt;

    private Boolean correct;

    private Integer orderIndex;

    public static boolean validate(QuestionOptModel model) {
        // 只要有一个字段为null就返回false
        return !(null == model.optName || null == model.optContent || null == model.orderIndex);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName == null ? null : optName.trim();
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent == null ? null : optContent.trim();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerAmt() {
        return answerAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_opt.answer_amt
     *
     * @param answerAmt the value for question_opt.answer_amt
     *
     * @mbggenerated
     */
    public void setAnswerAmt(Integer answerAmt) {
        this.answerAmt = answerAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_opt.correct
     *
     * @return the value of question_opt.correct
     *
     * @mbggenerated
     */
    public Boolean getCorrect() {
        return correct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_opt.correct
     *
     * @param correct the value for question_opt.correct
     *
     * @mbggenerated
     */
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_opt.order_index
     *
     * @return the value of question_opt.order_index
     *
     * @mbggenerated
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_opt.order_index
     *
     * @param orderIndex the value for question_opt.order_index
     *
     * @mbggenerated
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}