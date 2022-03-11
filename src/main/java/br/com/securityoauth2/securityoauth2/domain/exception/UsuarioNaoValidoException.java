package br.com.securityoauth2.securityoauth2.domain.exception;

public class UsuarioNaoValidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public UsuarioNaoValidoException(String msg) {
        super(msg);
    }

    public UsuarioNaoValidoException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
