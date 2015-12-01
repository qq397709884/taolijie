package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.OffQuestModel;
import com.fh.taolijie.service.impl.IntervalCheckService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffQuestModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    int insert(OffQuestModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    int insertSelective(OffQuestModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    OffQuestModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OffQuestModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table off_quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OffQuestModel record);

    List<OffQuestModel> findBy(OffQuestModel cmd);
    long countFindBy(OffQuestModel cmd);

    List<OffQuestModel> selectInBatch(List<Integer> idList);
}