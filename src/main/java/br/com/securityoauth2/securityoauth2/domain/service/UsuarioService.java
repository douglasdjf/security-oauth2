package br.com.securityoauth2.securityoauth2.domain.service;

import br.com.securityoauth2.securityoauth2.domain.exception.EmailNaoValidoException;
import br.com.securityoauth2.securityoauth2.domain.exception.UsuarioNaoEncontratoException;
import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import br.com.securityoauth2.securityoauth2.domain.model.Usuario;
import br.com.securityoauth2.securityoauth2.domain.repository.PermissaoRepository;
import br.com.securityoauth2.securityoauth2.domain.repository.UsuarioRepository;
import br.com.securityoauth2.securityoauth2.dto.UsuarioDTO;
import br.com.securityoauth2.securityoauth2.dto.UsuarioUpdateDTO;
import br.com.securityoauth2.securityoauth2.resource.exception.ResourceException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Usuario> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public UsuarioDTO create(UsuarioDTO usuarioDTO){

        if(usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent())
            throw new EmailNaoValidoException("e-mail já cadastrado por outro usuário");


        String senhaEncrypt =  new BCryptPasswordEncoder().encode(usuarioDTO.getSenha());

        Usuario usuarioNovoDto =   modelMapper.map(usuarioDTO, Usuario.class);
        usuarioNovoDto.setSenha(senhaEncrypt);

        Usuario usuarioPersistido = usuarioRepository.save(usuarioNovoDto);

        return  modelMapper.map(usuarioPersistido, UsuarioDTO.class);
    }


    public void deleteById(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new UsuarioNaoEncontratoException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioUpdateDTO update(@NotBlank  Long id,@Valid UsuarioUpdateDTO usuarioUpdateDTO) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(!usuarioOptional.isPresent())
            throw  new UsuarioNaoEncontratoException("Usuário não encontrado");

        Usuario usuarioUpdate = modelMapper.map(usuarioUpdateDTO,Usuario.class);

        BeanUtils.copyProperties(usuarioOptional.get(),usuarioUpdate,"permissao","nome");

        Usuario usuarioPostUpdate =  usuarioRepository.save(usuarioUpdate);

        return modelMapper.map(usuarioPostUpdate,UsuarioUpdateDTO.class);
    }

    private void preencheValidaPermissoes(Usuario usuarioUpdate){
        Usuario usuarioOld = usuarioRepository.findById(usuarioUpdate.getId()).get();

    Stream<Permissao> combinedStream = Stream.of(usuarioUpdate.getPermissao(),usuarioOld.getPermissao())
            .flatMap(Collection::stream);

      int i = 10;
    }

}
