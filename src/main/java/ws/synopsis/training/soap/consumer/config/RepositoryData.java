package ws.synopsis.training.soap.consumer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ws.synopsis.training.soap.consumer.model.Client;
import ws.synopsis.training.soap.consumer.repository.ClientRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

@Component
public class RepositoryData implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        logger.debug("Iniatilize component...");
        sendDatabase();
    }

    private void sendDatabase() {

        // DNI
        clientRepository.save(Client.builder().name("Client Uno").typeDocument("DNI").numberDocument("12345678").word("12345678").build());
        clientRepository.save(Client.builder().name("Client Dos").typeDocument("DNI").numberDocument("12345689").word("12345678").build());
        clientRepository.save(Client.builder().name("Client Tres").typeDocument("DNI").numberDocument("12345690").word("12345678").build());
        clientRepository.save(Client.builder().name("Client Cuatro").typeDocument("DNI").numberDocument("12345691").word("12345678").build());
        clientRepository.save(Client.builder().name("Client Cinco").typeDocument("CE").numberDocument("12345689111").word("12345678").build());
        clientRepository.save(Client.builder().name("Client Seis").typeDocument("CE").numberDocument("12345689222").word("12345678").build());

    }

}
