package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginaCobrancas {

    @JsonProperty(value = "totalPaginas")
    private Integer totalPaginas;

    @JsonProperty(value = "totalElementos")
    private Integer totalElementos;

    @JsonProperty(value = "ultimaPagina")
    private Boolean ultimaPagina;

    @JsonProperty(value = "primeiraPagina")
    private Boolean primeiraPagina;

    @JsonProperty(value = "tamanhoPagina")
    private Integer tamanhoPagina;

    @JsonProperty(value = "numeroDeElementos")
    private Integer numeroDeElementos;

    @JsonProperty(value = "cobrancas")
    private List<CobrancaRecuperada> cobrancas;

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

    public int getQuantidadeDePaginas() {
        return totalPaginas;
    }

}