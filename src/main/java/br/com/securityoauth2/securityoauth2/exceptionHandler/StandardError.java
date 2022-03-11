package br.com.securityoauth2.securityoauth2.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {

    private Long timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    private List<FieldMessage> erros;
}
