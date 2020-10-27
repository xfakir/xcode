package cn.xfakir.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_NAME = "exchange_demo";
    public static final String ROUTING_KEY = "routingKey_demo";
    public static final String QUEUE_NAME = "queue_demo";

    //声明交换机
    @Bean("itemTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    //声明队列
    @Bean("itemQueue")
    public Queue itemQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    //绑定队列和交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue,
                                     @Qualifier("itemTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }
    //声明交换机
    @Bean("itemTopicExchangeTTL")
    public Exchange topicExchange2(){
        return ExchangeBuilder.topicExchange("exchange_ttl").durable(true).build();
    }

    //声明队列
    @Bean("itemQueueTTL")
    public Queue itemQueue2(){
        //expire设置队列过期时间
        //
        return QueueBuilder.durable("queue_ttl")
                .deadLetterExchange("exchange_dlx").deadLetterRoutingKey(ROUTING_KEY)
                .ttl(10000).build();
    }

    //绑定队列和交换机
    @Bean("itemQueueExchangeTTL")
    public Binding itemQueueExchange2(@Qualifier("itemQueueTTL") Queue queue,
                                     @Qualifier("itemTopicExchangeTTL") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }

    //声明交换机
    @Bean("itemTopicExchangeDLX")
    public Exchange topicExchange3(){
        return ExchangeBuilder.topicExchange("exchange_dlx").durable(true).build();
    }

    //声明队列
    @Bean("itemQueueDLX")
    public Queue itemQueue3(){
        return QueueBuilder.durable("queue_dlx").build();
    }

    //绑定队列和交换机
    @Bean("itemQueueExchangeDLX")
    public Binding itemQueueExchange3(@Qualifier("itemQueueDLX") Queue queue,
                                      @Qualifier("itemTopicExchangeDLX") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }

}
