package org.hackathon.grup3.app.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class MessageResponseWrapper {

    private HttpStatus status;
    private MessageResponse messageResponse;
}
