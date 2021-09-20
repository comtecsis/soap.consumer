package ws.synopsis.training.soap.consumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.soap.consumer.model.Client;
import ws.synopsis.training.soap.consumer.service.ClientService;
import ws.synopsis.training.soap.consumer.service.LoginService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/client")
public class ClientController {

    private final ClientService service;

    @GetMapping
    public List<Client> list(){
        return service.list();
    }

    @PostMapping
    public void add(@RequestBody Client client) {
        service.add(client);
    }

    @PutMapping
    public void edit(@RequestBody Client client) {
        service.edit(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Long cliendId) {
        service.delete(cliendId);
    }

}
