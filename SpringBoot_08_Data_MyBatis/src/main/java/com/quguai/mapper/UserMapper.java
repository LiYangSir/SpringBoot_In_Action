package com.quguai.mapper;

import com.quguai.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Result(id = true, property = "id", column = "id")
    @Result(javaType = List.class, column = "id", property = "orders",
            many = @Many(select = "com.quguai.mapper.OrderMapper.getOrderByUId"))
    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);


    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert user(username, password) values(#{username}, #{password})")
    public int insertUser(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public int updateUser(User user);
}
