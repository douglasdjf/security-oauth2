package br.com.securityoauth2.securityoauth2.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Captura exceções de respostas de entidades do response
 * @author douglas
 *
 */

@ControllerAdvice
public class SecurityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StandardError standardError = StandardError.builder()
                                        .status(HttpStatus.BAD_REQUEST.value())
                                        .path(((ServletWebRequest)request).getRequest().getRequestURI())
                                        .timestamp(System.currentTimeMillis())
                                        .error(ex.getMessage())
                                        .message("Dados inválidos")
                                        .erros(criarListaFieldErros(ex.getBindingResult()))
                                        .build();

       return handleExceptionInternal(ex,standardError,headers,HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StandardError standardError = StandardError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .path(((ServletWebRequest)request).getRequest().getRequestURL().toString())
                .timestamp(System.currentTimeMillis())
                .error(ex.getCause().getMessage().toString())
                .message(ex.getMessage())
                .build();

        return super.handleExceptionInternal(ex,standardError, headers, HttpStatus.BAD_REQUEST, request);
    }


    private List<FieldMessage> criarListaFieldErros(BindingResult bindingResult){
        List<FieldMessage> erros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String field = fieldError.getField();
            String mensage =   fieldError.getField() + " "+ fieldError.getDefaultMessage()  ;
            erros.add(new FieldMessage(field, mensage));
        }
        return erros;
    }
}
