package gkr.abhishek.springbootrabbitmq.controller;

import gkr.abhishek.springbootrabbitmq.dto.MessageDTO;
import gkr.abhishek.springbootrabbitmq.publisher.RabbitMQJsonProducer;
import gkr.abhishek.springbootrabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;


    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return new ResponseEntity<>("Message sent to RabbitMQ", HttpStatus.OK);
    }

}
