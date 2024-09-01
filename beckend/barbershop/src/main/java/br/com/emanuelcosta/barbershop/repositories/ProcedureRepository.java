package br.com.emanuelcosta.barbershop.repositories;

import br.com.emanuelcosta.barbershop.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
}
