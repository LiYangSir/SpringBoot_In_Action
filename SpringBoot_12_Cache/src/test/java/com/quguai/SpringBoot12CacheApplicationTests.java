package com.quguai;

import com.quguai.bean.User;
import com.quguai.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBoot12CacheApplicationTests {

	@Resource
	UserMapper userMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate; //k-v都是字符串对象

	@Autowired
	RedisTemplate redisTemplate;  //k-v都是对象

	@Autowired
	RedisTemplate<Object, User> userRedisTemplate;  //k-v都是对象
	/**
	 * stringRedisTemplate.opsForValue();
	 * stringRedisTemplate.opsForHash();
	 * stringRedisTemplate.opsForSet();
	 * stringRedisTemplate.opsForZSet();
	 * stringRedisTemplate.opsForList();
	 */
	@Test
	void contextLoads() {
//		stringRedisTemplate.opsForValue().append("msg", "hello");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

		stringRedisTemplate.opsForList().leftPush("list", "1");
//		List<String> list = stringRedisTemplate.opsForList().range("list", 0, -1);
//		System.out.println(list);
	}

	@Test
	void test(){
		User user = userMapper.getUserById(1);
		// 默认使用jdk序列化机制，将序列化的数据保存到redis当中
		userRedisTemplate.opsForValue().set("user_1", user);
		// 将数据以JSON格式保存
	}

}
