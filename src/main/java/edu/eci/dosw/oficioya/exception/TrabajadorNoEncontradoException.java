package edu.eci.dosw.oficioya.exception;

public class TrabajadorNoEncontradoException extends RuntimeException{
    public TrabajadorNoEncontradoException(Long id){
        super("No se encontro un trabajador con el id " + id);
    }
}

