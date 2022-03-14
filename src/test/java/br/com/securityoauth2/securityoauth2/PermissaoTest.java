package br.com.securityoauth2.securityoauth2;

import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import br.com.securityoauth2.securityoauth2.domain.repository.PermissaoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class PermissaoTest {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Test
    void deveBuscarPermissaoPorId(){

        Permissao permissao = permissaoRepository.findById(1L).get();
        Assert.assertNotNull(permissao);

        System.out.println(("PermissaoId:" +permissao.getId()+ " "+"PermissaoDescricao:" + permissao.getDescricao()));

    }

}
