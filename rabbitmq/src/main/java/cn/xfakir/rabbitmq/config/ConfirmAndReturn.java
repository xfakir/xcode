package cn.xfakir.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class ConfirmAndReturn implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        //此方法用于监听消息确认结果（消息是否发送到交换机）
        if (b) {
            System.out.println("-----message was sent to exchange successfully: " + s);
        } else {
            System.out.println("-----message failed to be sent to exchange");
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        //此方法用于return监听(当交换机分发消息到队列失败时执行)
        System.out.println(s+" "+s1+" "+s2);
    }
}
