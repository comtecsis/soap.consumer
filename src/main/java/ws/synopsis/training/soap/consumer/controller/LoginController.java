package ws.synopsis.training.soap.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.service.LoginService;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService service;

}
