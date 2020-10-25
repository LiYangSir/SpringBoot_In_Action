package com.quguai.service;

import com.quguai.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

//    @RabbitListener(queues = "quguai.news")
//    public void receive(Book book) {
//        System.out.println("监听消息" + book);
//    }
}
