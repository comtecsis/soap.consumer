package ws.synopsis.training.soap.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.soap.consumer.model.Client;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Optional<Client> findByNumberDocumentAndWord(String numberDocument, String word);

}
