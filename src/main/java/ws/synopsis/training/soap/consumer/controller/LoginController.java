package ws.synopsis.training.soap.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.soap.consumer.enumeration.TrainingStatusEnum;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.request.SecurityRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.response.SecurityToken;
import ws.synopsis.training.soap.consumer.response.TrainingResponse;
import ws.synopsis.training.soap.consumer.response.TrainingStatus;
import ws.synopsis.training.soap.consumer.service.LoginService;

import javax.xml.ws.Response;
import java.rmi.server.RemoteServer;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @GetMapping("")
    public ResponseEntity<TrainingResponse<?>> unauthenticated() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new TrainingResponse<>(TrainingStatusEnum.ERROR_UNAUTHENTICATED.getStatus()));
    }

    @PostMapping("/auth")
    public ResponseEntity<TrainingResponse<LoginResponse>> login(@RequestBody LoginRequest beanRequest){
        // Intento de login
        SecurityToken token = (SecurityToken) authenticationManager.authenticate(new SecurityRequest(beanRequest.getNumberDocument(), null, beanRequest));
        // Login Exitoso
        return ResponseEntity.ok()
                .body(
                    TrainingResponse.<LoginResponse>builder()
                        .status(TrainingStatusEnum.OK.getStatus())
                        .data(new LoginResponse(token.getTokenInfo()))
                        .build()
                );
    }

}
