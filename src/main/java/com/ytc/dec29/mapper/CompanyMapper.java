package com.ytc.dec29.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.ytc.dec29.model.*;
public interface CompanyMapper {
    @Select("select * from ytc_company_info;")
    @Results(id="resultMap",value={
        @Result(property = "id",column="c_id"),
        @Result(property = "name",column="c_name"),
        @Result(property = "password",column="c_password"),
    })
    List<Company> getAllCompanies();

    @Select("select count(*) from ytc_company_info where c_name = #{name};")
    @ResultMap("resultMap")
    Integer doesCompanyExist(String name);

    @Select("select c_password from ytc_company_info where c_name = #{name}")
    String getPassword(String name, String password);

	@Insert(value={
		"insert into ytc_company_info "+
		"(c_name,c_password) values (#{name},#{password});"
    })
    @SelectKey(keyProperty = "id",keyColumn = "c_id",before = false,resultType = Integer.class, statement = "select last_insert_id()")
    public void add(Company company);


}
