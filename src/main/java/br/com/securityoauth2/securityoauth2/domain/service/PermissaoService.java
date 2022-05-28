package br.com.securityoauth2.securityoauth2.domain.service;

import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import br.com.securityoauth2.securityoauth2.domain.model.Usuario;
import br.com.securityoauth2.securityoauth2.domain.repository.PermissaoRepository;
import br.com.securityoauth2.securityoauth2.dto.PermissaoUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Permissao> findAll(Pageable pageable){
        return permissaoRepository.findAll(pageable);
    }
}
