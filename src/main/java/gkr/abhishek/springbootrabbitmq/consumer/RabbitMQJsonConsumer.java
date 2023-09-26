package gkr.abhishek.springbootrabbitmq.consumer;

import gkr.abhishek.springbootrabbitmq.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumerJSON(MessageDTO messageDTO){
        LOGGER.info("Received message {}",messageDTO);
    }

}
