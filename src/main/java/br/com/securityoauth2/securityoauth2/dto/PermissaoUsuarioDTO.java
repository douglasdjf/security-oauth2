package br.com.securityoauth2.securityoauth2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissaoUsuarioDTO implements Serializable {

    @NotNull
    private Long id;

    private String descricao;
}
