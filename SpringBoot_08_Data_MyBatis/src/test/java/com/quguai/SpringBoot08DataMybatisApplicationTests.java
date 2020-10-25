package com.quguai;

import com.quguai.bean.User;
import com.quguai.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot08DataMybatisApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
		User userById = userMapper.getUserById(1);
		System.out.println(userById);
	}

}
