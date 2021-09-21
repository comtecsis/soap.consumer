package ws.synopsis.training.soap.consumer.service;

import org.springframework.web.bind.annotation.RequestBody;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.security.TokenInfo;

public interface LoginService {

    public TokenInfo login(LoginRequest beanRequest);

}
