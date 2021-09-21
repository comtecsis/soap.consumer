package ws.synopsis.training.soap.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.synopsis.training.soap.consumer.enumeration.TrainingStatusEnum;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.response.TrainingResponse;
import ws.synopsis.training.soap.consumer.response.TrainingStatus;
import ws.synopsis.training.soap.consumer.service.LoginService;

import javax.xml.ws.Response;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/login")
public class LoginController {

    private final LoginService service;

    @PostMapping("/auth")
    public ResponseEntity<TrainingResponse<LoginResponse>> login(@RequestBody LoginRequest beanRequest){
        TrainingResponse<LoginResponse> response = new TrainingResponse<>();
        response.setStatus(TrainingStatusEnum.OK.getStatus());
        response.setData(service.login(beanRequest));
        return ResponseEntity.ok().body(response);
    }

}
