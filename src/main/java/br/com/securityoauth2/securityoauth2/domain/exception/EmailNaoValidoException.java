package br.com.securityoauth2.securityoauth2.domain.exception;

public class EmailNaoValidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailNaoValidoException(String msg) {
        super(msg);
    }

    public EmailNaoValidoException(String msg,Throwable cause) {
        super(msg,cause);
    }
}