package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.BulletinModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulletinModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int insert(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int insertSelective(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    BulletinModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BulletinModel record);

    List<BulletinModel> getAll(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);
}