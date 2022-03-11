package br.com.securityoauth2.securityoauth2.domain.exception;

public class UsuarioNaoEncontratoException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public UsuarioNaoEncontratoException(String msg) {
        super(msg);
    }

    public UsuarioNaoEncontratoException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
