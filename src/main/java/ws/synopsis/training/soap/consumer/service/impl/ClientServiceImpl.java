package ws.synopsis.training.soap.consumer.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ws.synopsis.training.soap.consumer.model.Client;
import ws.synopsis.training.soap.consumer.repository.ClientRepository;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;
import ws.synopsis.training.soap.consumer.service.ClientService;
import ws.synopsis.training.soap.consumer.service.LoginService;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    @Override
    public List<Client> list() {
        return this.repository.findAll();
    }

    @Override
    public void add(Client client) {
        this.repository.save(client);
    }

    @Override
    public void edit(Client client) {
        this.repository.save(client);
    }

    @Override
    public void delete(Long cliendId) {
        this.repository.delete(this.repository.findById(cliendId).get());
    }
}
