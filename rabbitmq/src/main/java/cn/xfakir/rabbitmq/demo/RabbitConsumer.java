package cn.xfakir.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    @RabbitListener(queues = "queue_demo")
    public void msg(String msg) {
        System.out.println("rabbitmq msg: " + msg);
    }

    @RabbitListener(queues = "queue_dlx")
    public void msgDLX(String msg) {
        System.out.println("rabbitmq dlx msg: " + msg);
    }
}
