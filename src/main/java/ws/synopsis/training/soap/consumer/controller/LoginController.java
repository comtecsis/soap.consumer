package ws.synopsis.training.soap.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.service.LoginService;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    @GetMapping
    public String index() {
        return "login/index";
    }


}
