package com.fh.taolijie.domain.quest;

public class QuestCollRelModel {
    private Integer id;

    private Integer questId;

    private Integer collegeId;
    private String collegeName;

    public QuestCollRelModel() {}

    public QuestCollRelModel(Integer questId, Integer collegeId) {
        this.questId = questId;
        this.collegeId = collegeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_college_rel.quest_id
     *
     * @return the value of quest_college_rel.quest_id
     *
     * @mbggenerated
     */
    public Integer getQuestId() {
        return questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_college_rel.quest_id
     *
     * @param questId the value for quest_college_rel.quest_id
     *
     * @mbggenerated
     */
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column quest_college_rel.college_id
     *
     * @return the value of quest_college_rel.college_id
     *
     * @mbggenerated
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column quest_college_rel.college_id
     *
     * @param collegeId the value for quest_college_rel.college_id
     *
     * @mbggenerated
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}