package inter.cobranca.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import inter.cobranca.model.enums.SituacaoBoleto;
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

    private String nossoNumero;
    private String seuNumero;
    private SituacaoBoleto situacao;
    private String dataHoraSituacao;
    private BigDecimal valorTotalRecebimento;
    private BigDecimal valorNominal;
    private String codigoBarras;
    private String linhaDigitavel;

}