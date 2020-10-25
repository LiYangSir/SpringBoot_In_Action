package com.quguai;

import com.quguai.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot13RabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createExchange() {
		// 创建交换器
//		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		// 创建队列
//		amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
		// 绑定
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null));
		System.out.println("创建完成");
	}
	/**
	 * 点对点消息
	 */
	@Test
	void contextLoads() {

		//Message需要自己构建一个；定义消息体内容和消息头
		//rabbitTemplate.send(exchange, routeKey, message);
		//object 默认当成消息体，只需要传入发送的对象，自己序列化给rabbitMQ
		//rabbitTemplate.convertAndSend(exchange, routeKey, object);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "SpringBoot First Message");
//		rabbitTemplate.convertAndSend("exchange.direct", "quguai.news", map);
//		rabbitTemplate.convertAndSend("exchange.topic", "quguai.news", new Book(1, "西游记", "吴承恩"));
		rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.haha", new Book(1, "西游记", "吴承恩"));
	}

	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("quguai.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	/**
	 * 广播
	 *
	 */

	@Test
	public void publish() {
		rabbitTemplate.convertAndSend("exchange.fanout", "", new Book(2, "水浒传", "施耐庵"));
	}
}
