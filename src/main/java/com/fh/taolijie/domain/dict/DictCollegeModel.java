package com.fh.taolijie.domain.dict;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DictCollegeModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.full_name
     *
     * @mbggenerated
     */
    private String fullName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.short_name
     *
     * @mbggenerated
     */
    private String shortName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.province_id
     *
     * @mbggenerated
     */
    private Integer provinceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.city_id
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.region_id
     *
     * @mbggenerated
     */
    private Integer regionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_college.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.id
     *
     * @return the value of dict_college.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.id
     *
     * @param id the value for dict_college.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.full_name
     *
     * @return the value of dict_college.full_name
     *
     * @mbggenerated
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.full_name
     *
     * @param fullName the value for dict_college.full_name
     *
     * @mbggenerated
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.short_name
     *
     * @return the value of dict_college.short_name
     *
     * @mbggenerated
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.short_name
     *
     * @param shortName the value for dict_college.short_name
     *
     * @mbggenerated
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.province_id
     *
     * @return the value of dict_college.province_id
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.province_id
     *
     * @param provinceId the value for dict_college.province_id
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.city_id
     *
     * @return the value of dict_college.city_id
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.city_id
     *
     * @param cityId the value for dict_college.city_id
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.region_id
     *
     * @return the value of dict_college.region_id
     *
     * @mbggenerated
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.region_id
     *
     * @param regionId the value for dict_college.region_id
     *
     * @mbggenerated
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_college.address
     *
     * @return the value of dict_college.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_college.address
     *
     * @param address the value for dict_college.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}