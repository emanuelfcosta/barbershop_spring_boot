package br.com.emanuelcosta.barbershop.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = 1841638994383798339L;

    public DatabaseException(String msg){
        super(msg);
    }
}
