package com.jiajinshuo.sbt_senior.mapper;

import com.jiajinshuo.sbt_senior.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jiajinshuo
 * @create 2020-03-24 11:30
 */
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId}")
    public void insertEmployee(Employee employee);
}
