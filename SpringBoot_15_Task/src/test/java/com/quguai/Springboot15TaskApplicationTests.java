package com.quguai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot15TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("通知今晚开会");
		simpleMailMessage.setText("今晚8：30");
		simpleMailMessage.setFrom("1315223452@qq.com");
		simpleMailMessage.setTo("17612733884@163.com");
		javaMailSender.send(simpleMailMessage);
	}

	@Test
	void send() throws MessagingException {

		// 复杂消息邮件
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject("Subject");
		helper.setText("<b>今天好开心</b>", true);
		helper.addAttachment("1.jpg", new File("C:\\Users\\LiYangSir\\Pictures\\测试数据集\\监控7.jpg"));
		helper.addAttachment("2.jpg", new File("C:\\Users\\LiYangSir\\Pictures\\测试数据集\\监控8.jpg"));
		helper.setFrom("1315223452@qq.com");
		helper.setTo("17612733884@163.com");
		javaMailSender.send(helper.getMimeMessage());
	}

}
