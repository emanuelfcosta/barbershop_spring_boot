package br.com.emanuelcosta.barbershop.services;

import br.com.emanuelcosta.barbershop.entities.Employee;
import br.com.emanuelcosta.barbershop.repositories.EmployeeRepository;
import br.com.emanuelcosta.barbershop.services.exceptions.DatabaseException;
import br.com.emanuelcosta.barbershop.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.get();
    }

    public Employee insert(Employee obj){
        return employeeRepository.save(obj);

    }

    public Employee update(Long id, Employee obj){
        try{
            Employee entity = employeeRepository.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setDateOfBirth(obj.getDateOfBirth());
            entity.setAddress(obj.getAddress());
            entity.setSalary(obj.getSalary());

            return employeeRepository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id){
        try{
            Employee obj = employeeRepository.findById(id).get();

            employeeRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw  new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
