package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.dict.DictRegionModel;
import com.fh.taolijie.domain.dict.DictRegionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictRegionModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int countByExample(DictRegionModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int deleteByExample(DictRegionModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int insert(DictRegionModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int insertSelective(DictRegionModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    List<DictRegionModel> selectByExample(DictRegionModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    DictRegionModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DictRegionModel record, @Param("example") DictRegionModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DictRegionModel record, @Param("example") DictRegionModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DictRegionModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_region
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DictRegionModel record);
}