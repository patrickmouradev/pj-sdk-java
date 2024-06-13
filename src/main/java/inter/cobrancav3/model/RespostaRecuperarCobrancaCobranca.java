package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.cobrancav3.model.enums.OrigemRecebimento;
import inter.cobrancav3.model.enums.SituacaoCobranca;
import inter.cobrancav3.model.enums.TipoCobranca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaRecuperarCobrancaCobranca {

    private String codigoSolicitacao;
    private String seuNumero;
    private String dataEmissao;
    private String dataVencimento;
    private BigDecimal valorNominal;
    private TipoCobranca tipoCobranca;
    private SituacaoCobranca situacao;
    private String dataSituacao;
    private String valorTotalRecebido;
    private OrigemRecebimento origemRecebimento;
    private String motivoCancelamento;
    private Boolean arquivada;
    private List<Desconto> descontos;
    private Multa multa;
    private Mora mora;
    private Pessoa pagador;

}