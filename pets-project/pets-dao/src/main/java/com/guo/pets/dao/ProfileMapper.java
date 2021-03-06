package com.guo.pets.dao;

import com.guo.pets.domain.Profile;
import com.guo.pets.domain.ProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    long countByExample(ProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int deleteByExample(ProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int insert(Profile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int insertSelective(Profile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    List<Profile> selectByExample(ProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    Profile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int updateByExampleSelective(@Param("record") Profile record, @Param("example") ProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int updateByExample(@Param("record") Profile record, @Param("example") ProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int updateByPrimaryKeySelective(Profile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets-profile
     *
     * @mbg.generated Wed Mar 14 22:21:41 CST 2018
     */
    int updateByPrimaryKey(Profile record);
}