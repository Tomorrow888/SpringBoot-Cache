package com.jiajinshuo.sbt_senior.service;

import com.jiajinshuo.sbt_senior.domain.Employee;
import com.jiajinshuo.sbt_senior.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author jiajinshuo
 * @create 2020-03-24 12:40
 */
@Service
public class EmployeeService {

    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 将方法的运行结果进行缓存.
     * emp表示方法的返回值放到哪个缓存中
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut:既调用方法又更新缓存数据
     * 修改数据库某个数据同时更新缓存
     * @param employee
     * @return
     */
    @CachePut(value = "emp" ,key = "#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * key：指定要清除的缓存
     * @param id
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){

    }
    /**
     * 使用redisTemplate操作hash
     */
    public Employee selectById(Integer id){
        if(redisTemplate.opsForHash().hasKey("employee",id)){
            return (Employee)redisTemplate.opsForHash().get("employee", id);
        }else {
            Employee emp = new Employee();
            redisTemplate.opsForHash().put("employee",id,emp);
            return emp;
        }
    }
}
