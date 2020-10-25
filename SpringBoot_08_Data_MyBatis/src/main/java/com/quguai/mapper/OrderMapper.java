package com.quguai.mapper;

import com.quguai.bean.Order;
import org.apache.ibatis.annotations.*;

import static org.apache.ibatis.type.JdbcType.TIMESTAMP;

@Mapper
public interface OrderMapper {

    @Select("select * from orders where id=#{id}")
    public Order getOrderById(Integer id);

    @Result(column = "ordertime", property = "date", jdbcType = TIMESTAMP)
    @Select("select * from orders where uid=#{id}")
    public Order getOrderByUId(Integer id);


    @Delete("delete from orders where id=#{id}")
    public int deleteOrderById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert orders(ordertime, total) values(#{ordertime}, #{total})")
    public int insertOrder(Order order);

    @Update("update orders set ordertime=#{ordertime},total=#{total} where id=#{id}")
    public int updateOrder(Order order);
}
