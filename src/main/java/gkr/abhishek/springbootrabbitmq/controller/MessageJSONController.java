package gkr.abhishek.springbootrabbitmq.controller;

import gkr.abhishek.springbootrabbitmq.dto.MessageDTO;
import gkr.abhishek.springbootrabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJSONController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJSONController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJSONMessage(@RequestBody MessageDTO messageDTO){
        jsonProducer.sendJsonMessage(messageDTO);
        return new ResponseEntity<>("Message sent to RabbitMQ", HttpStatus.OK);
    }

}
