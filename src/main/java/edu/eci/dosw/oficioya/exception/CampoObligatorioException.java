package edu.eci.dosw.oficioya.exception;

public class CampoObligatorioException extends RuntimeException{
    public CampoObligatorioException(String campo){
        super("El campo " + campo + " es obligatorio");
    }
}
