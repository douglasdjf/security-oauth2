package br.com.securityoauth2.securityoauth2.dto;

import br.com.securityoauth2.securityoauth2.domain.model.Permissao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioUpdateDTO implements Serializable {

    @NotNull
    @NotBlank
    private String nome;

    @NotEmpty
    private Set<PermissaoUsuarioDTO> permissao ;
}
