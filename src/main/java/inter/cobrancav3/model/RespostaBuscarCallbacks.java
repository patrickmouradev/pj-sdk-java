package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaBuscarCallbacks {

    private String webhookUrl;
    private Integer numeroTentativa;
    private String dataHoraDisparo;
    private Boolean sucesso;
    private Integer httpStatus;
    private String mensagemErro;
    private List<Payload> payload;

}