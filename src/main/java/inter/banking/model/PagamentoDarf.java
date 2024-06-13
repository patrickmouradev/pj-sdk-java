package inter.banking.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagamentoDarf {

    /**
     * Campo para informar o cpf ou cnpj do pagador
     */
    private String cnpjCpf;

    private String codigoReceita;

    /**
     * <p>Formato aceito: YYYY-MM-DD</p>
     */
    private String dataVencimento;

    private String descricao;

    private String nomeEmpresa;

    private String telefoneEmpresa;

    /**
     * Campo para informar o período de apuração da DARF
     * <p>Formato aceito: YYYY-MM-DD</p>
     */
    private String periodoApuracao;

    private String valorPrincipal;

    private String valorMulta;

    private String valorJuros;

    private String referencia;

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