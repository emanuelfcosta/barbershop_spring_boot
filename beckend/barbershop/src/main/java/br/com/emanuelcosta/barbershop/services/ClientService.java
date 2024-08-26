package br.com.emanuelcosta.barbershop.services;

import br.com.emanuelcosta.barbershop.entities.Client;
import br.com.emanuelcosta.barbershop.repositories.ClientRepository;
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
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.get();
    }

    public Client insert(Client obj){
        return clientRepository.save(obj);
    }

    public Client update(Long id, Client obj){
        try {
            Client entity = clientRepository.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setNascimento(obj.getNascimento());
            entity.setSalario(obj.getSalario());

            return clientRepository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id){
        try {
            Client obj = clientRepository.findById(id).get();

            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
