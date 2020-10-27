package cn.xfakir.rabbitmq.controller;

import cn.xfakir.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMsg")
    public String sendMsg(@RequestParam String msg) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,RabbitmqConfig.ROUTING_KEY,msg);
        return "success";
    }

    @RequestMapping("/sendMsgWithErrorExchangeName")
    public String sendMsgWithErrorExchangeName(@RequestParam String msg) {
        rabbitTemplate.convertAndSend("aa","aa",msg);
        return "success";
    }

    @RequestMapping("/sendMsgWithErrorRoutingKey")
    public String sendMsgWithErrorRoutingKey(@RequestParam String msg) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,"aa",msg);
        return "success";
    }

    @RequestMapping("/sendMsgToTTLQueue")
    public String sendMsgToTTLQueue(@RequestParam String msg) {
        rabbitTemplate.convertAndSend("exchange_ttl",RabbitmqConfig.ROUTING_KEY,msg);
        return "success";
    }
}
