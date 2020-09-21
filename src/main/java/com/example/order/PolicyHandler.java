package com.example.order;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @StreamListener(Processor.INPUT)
    public void onEventByString(@Payload String OrderPlaced){
        System.out.println(OrderPlaced);
    }

    @StreamListener(Processor.INPUT)
    public void onEventByObject(@Payload OrderPlaced orderPlaced){
        if("OrderPlaced".equals(orderPlaced.getEventType())){
            System.out.println("onEventByObject getEventType:" + orderPlaced.getEventType());
        }
    }
}
