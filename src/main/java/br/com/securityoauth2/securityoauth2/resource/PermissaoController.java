package br.com.securityoauth2.securityoauth2.resource;

import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import br.com.securityoauth2.securityoauth2.domain.model.Usuario;
import br.com.securityoauth2.securityoauth2.domain.service.PermissaoService;
import br.com.securityoauth2.securityoauth2.domain.service.UsuarioService;
import br.com.securityoauth2.securityoauth2.dto.UsuarioDTO;
import br.com.securityoauth2.securityoauth2.dto.UsuarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO')")
    public ResponseEntity<Page<Permissao>> findAll(Pageable pageable){
        return ResponseEntity.ok(permissaoService.findAll(pageable));
    }
}
