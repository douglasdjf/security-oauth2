package br.com.securityoauth2.securityoauth2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefixo.versao}")
public class ApiController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getApi(){
        return ResponseEntity.ok("Api Acesso");
    }
}
