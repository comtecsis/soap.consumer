package ws.synopsis.training.soap.consumer.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import ws.synopsis.training.soap.consumer.repository.ClientRepository;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.service.LoginService;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private ClientRepository repository;

    @Override
    public LoginResponse login(LoginRequest beanRequest) {
        return null;
    }

}
