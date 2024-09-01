package br.com.emanuelcosta.barbershop.services;

import br.com.emanuelcosta.barbershop.entities.Procedure;
import br.com.emanuelcosta.barbershop.repositories.ProcedureRepository;
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
public class ProcedureService {
    @Autowired
    private ProcedureRepository procedureRepository;

    public List<Procedure> findAll(){
        return procedureRepository.findAll();

    }
    public Procedure findById(Long id){
        Optional<Procedure> obj = procedureRepository.findById(id);
        return obj.get();
    }
    public Procedure inset(Procedure obj){
        return procedureRepository.save(obj);
    }

    public Procedure update(Long id, Procedure obj){
        try{
            Procedure entity = procedureRepository.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setPrice(obj.getPrice());

            return procedureRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id){
        try{
            //Procedure obj = procedureRepository.findById(id).get();

            procedureRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw  new ResourceNotFoundException(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
