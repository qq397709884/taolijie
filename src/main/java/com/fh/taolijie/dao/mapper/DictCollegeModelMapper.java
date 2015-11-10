package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.dict.DictCollegeModel;
import com.fh.taolijie.domain.dict.DictCollegeModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCollegeModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int countByExample(DictCollegeModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int deleteByExample(DictCollegeModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int insert(DictCollegeModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int insertSelective(DictCollegeModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    List<DictCollegeModel> selectByExample(DictCollegeModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    DictCollegeModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DictCollegeModel record, @Param("example") DictCollegeModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DictCollegeModel record, @Param("example") DictCollegeModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DictCollegeModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_college
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DictCollegeModel record);

    List<DictCollegeModel> selectAll();
}