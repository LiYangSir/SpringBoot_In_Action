package com.quguai.service;


import org.apache.dubbo.config.annotation.DubboService;

@DubboService  //将服务发不出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<<厉害了我的国>>";
    }
}
