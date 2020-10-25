package cn.quguai.springboot_config;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConfigApplicationTests {

	@Test
	void contextLoads() {
		Logger logger = LoggerFactory.getLogger(getClass());

		logger.trace("Hello World");
		logger.debug("Hello World");
		logger.info("Hello World");
		logger.warn("Hello World");
		logger.error("Hello World");

	}

}
