package com.fh.taolijie.domain.dict;

public class DictRegionModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_region.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_region.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_region.province_id
     *
     * @mbggenerated
     */
    private Integer provinceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_region.city_id
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_region.id
     *
     * @return the value of dict_region.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_region.id
     *
     * @param id the value for dict_region.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_region.name
     *
     * @return the value of dict_region.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_region.name
     *
     * @param name the value for dict_region.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_region.province_id
     *
     * @return the value of dict_region.province_id
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_region.province_id
     *
     * @param provinceId the value for dict_region.province_id
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_region.city_id
     *
     * @return the value of dict_region.city_id
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_region.city_id
     *
     * @param cityId the value for dict_region.city_id
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}