package br.com.emanuelcosta.barbershop.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException  extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7994642114106489758L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
