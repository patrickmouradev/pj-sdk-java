package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import inter.cobrancav3.model.enums.SituacaoCobranca;
import inter.cobrancav3.model.enums.TipoCobranca;
import inter.cobrancav3.model.enums.TipoDataCobranca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroBaseRecuperarCobrancas {

    /**
     * Caso o campo situacao seja:
     * <ul>
     *     <li>EXPIRADO as datas corresponderão a data de expiração dos boletos;</li>
     *     <li>VENCIDO(default) as datas corresponderão a data de vencimento dos boletos;</li>
     *     <li>EMABERTO as datas corresponderão a data de emissão dos boletos;</li>
     *     <li>PAGO as datas corresponderão a data de pagamento dos boletos;</li>
     *     <li>CANCELADO as datas corresponderão a data de cancelamento dos boletos;</li>
     * </ul>
     */
    private TipoDataCobranca filtrarDataPor;

    /**
     * Filtro pela situação da cobrança.
     */
    private SituacaoCobranca situacao;

    /**
     * Filtro pelo nome do pagador
     */
    private String pessoaPagadora;

    /**
     * Campo para informar o cpf ou cnpj do pagador
     */
    private String cpfCnpjPessoaPagadora;

    /**
     * Campo para informar o código seuNumero
     */
    private String seuNumero;

    /**
     * Campo para informar o tipo da cobrança
     */
    private TipoCobranca tipoCobranca;

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
