package ws.synopsis.training.soap.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.soap.consumer.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
