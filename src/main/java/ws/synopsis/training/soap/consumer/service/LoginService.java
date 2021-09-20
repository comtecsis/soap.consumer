package ws.synopsis.training.soap.consumer.service;

import org.springframework.web.bind.annotation.RequestBody;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;

public interface LoginService {

    public LoginResponse login(LoginRequest beanRequest);

}
