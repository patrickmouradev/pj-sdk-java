package inter.pix.model;

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
public class ItemPayload {

    private String chave;
    private ComponenteValor componentesValor;
    private List<RequisicaoBodyDevolucao> devolucoes;
    private String endToEndId;
    private String horario;
    private String infoPagador;
    private String txid;
    private String valor;

}