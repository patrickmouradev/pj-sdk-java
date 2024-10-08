package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoEmitirCobranca {
    /**
     * REQUERIDO
     * <p><Campo Seu Número do título</p>
     */
    private String seuNumero;

    /**
     * REQUERIDO
     * <p>Valor Nominal do título</p>
     * <p>O valor nominal deve ser maior ou igual à R$2.50</p>
     */
    private BigDecimal valorNominal;

    /**
     * REQUERIDO
     * <p>Data de vencimento do título</p>
     * <p>Formato aceito: YYYY-MM-DD</p>
     */
    private String dataVencimento;

    /**
     * REQUERIDO
     * REQUERIDO-ZERO (enviar mesmo se o valor for 0)
     * <p>Número de dias corridos após o vencimento para o cancelamento efetivo automático do boleto. (de 0 até 60)</p>
     */
    private Integer numDiasAgenda;

    /**
     * REQUERIDO
     */
    private Pessoa pagador;

    private Desconto desconto;
    private Multa multa;
    private Mora mora;
    private Mensagem mensagem;
    private Pessoa beneficiarioFinal;

    @Builder.Default
    private Map<String, Object> camposAdicionais = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getCamposAdicionais() {
        return camposAdicionais;
    }

    @JsonAnySetter
    public void setCamposAdicionais(final String nome, final Object valor) {
        this.camposAdicionais.put(nome, valor);
    }

}