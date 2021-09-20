package ws.synopsis.training.soap.consumer.service;

import ws.synopsis.training.soap.consumer.model.Client;
import ws.synopsis.training.soap.consumer.request.LoginRequest;
import ws.synopsis.training.soap.consumer.response.LoginResponse;

import java.util.List;

public interface ClientService {

    public List<Client> list();
    public void add(Client client);
    public void edit(Client client);
    public void delete(Long cliendId);

}
