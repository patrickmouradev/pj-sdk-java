package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.cobrancav3.model.enums.OrigemRecebimento;
import inter.cobrancav3.model.enums.SituacaoCobranca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    private String codigoSolicitacao;
    private String seuNumero;
    private SituacaoCobranca situacao;
    private String dataHoraSituacao;
    private String valorTotalRecebido;
    private OrigemRecebimento origemRecebimento;
    private String nossoNumero;
    private String codigoBarras;
    private String linhaDigitavel;
    private String txid;
    private String pixCopiaECola;

}