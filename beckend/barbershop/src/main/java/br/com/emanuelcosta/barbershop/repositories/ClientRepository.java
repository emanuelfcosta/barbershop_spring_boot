package br.com.emanuelcosta.barbershop.repositories;

import br.com.emanuelcosta.barbershop.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
