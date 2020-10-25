package com.quguai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 1、体验缓存
 * 2、整合redis
 * 		1) 引入starter
 * 		2) 配置redis
 * 		3) 测试缓存
 * 			原理使用CacheManage---cache 缓存组件来实际给缓存中存取数据
 * 			1） 引入redis starter 容器保存的是 RedisCacheManager
 * 			2) 	RedisCacheManager 帮我们创建RedisCache进行缓存数据
 * 			3） 默认保存二进制的结果
 * 				1、引入redis的starter，cacheManager变为RedisCacheManager
 * 				2、默认创建的RedisTemplate操作redis使用RedisTemplate<Object, Object>
 * 				 自定义CacheManager
 */
//  整合redis
@MapperScan("com.quguai.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot12CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot12CacheApplication.class, args);
	}

}
