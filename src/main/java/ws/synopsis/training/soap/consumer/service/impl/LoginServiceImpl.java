package ws.synopsis.training.soap.consumer.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;
import ws.synopsis.training.soap.consumer.exception.TrainingAuthException;
import ws.synopsis.training.soap.consumer.model.Client;
import ws.synopsis.training.soap.consumer.repository.ClientRepository;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.request.SecurityRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.response.SecurityToken;
import ws.synopsis.training.soap.consumer.security.CustomAuthenticationProvider;
import ws.synopsis.training.soap.consumer.security.TokenInfo;
import ws.synopsis.training.soap.consumer.service.LoginService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private ClientRepository repository;

    @Override
    public TokenInfo login(LoginRequest beanRequest) {

        Optional<Client> optClient = repository.findByNumberDocumentAndWord(beanRequest.getNumberDocument(), beanRequest.getWord());

        if(optClient.isPresent())
        {
            Client client = optClient.get();
            return new TokenInfo(client);
        }

        throw new TrainingAuthException("El usuario no existe.");
    }

}
