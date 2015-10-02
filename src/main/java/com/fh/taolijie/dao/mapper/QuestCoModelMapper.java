package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.QuestCoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestCoModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    int insert(QuestCoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    int insertSelective(QuestCoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    QuestCoModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuestCoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection_quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuestCoModel record);

    List<QuestCoModel> findBy(QuestCoModel example);
    long countFindBy(QuestCoModel example);
}