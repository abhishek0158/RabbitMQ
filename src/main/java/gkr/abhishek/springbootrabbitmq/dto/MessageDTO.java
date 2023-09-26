package gkr.abhishek.springbootrabbitmq.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private String header;
    private String body;
    private String footer;
}
