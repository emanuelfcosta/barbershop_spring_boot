package br.com.emanuelcosta.barbershop.repositories;

import br.com.emanuelcosta.barbershop.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
