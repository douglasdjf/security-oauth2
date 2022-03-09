package br.com.securityoauth2.securityoauth2.domain.service;

import br.com.securityoauth2.securityoauth2.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
}
