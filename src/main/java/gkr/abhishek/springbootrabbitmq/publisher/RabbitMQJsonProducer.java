package gkr.abhishek.springbootrabbitmq.publisher;

import gkr.abhishek.springbootrabbitmq.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(MessageDTO messageDTO){
        LOGGER.info(String.format("JSON message sent -> %s",messageDTO.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,messageDTO);
    }
}
