package inter.pix.model;

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
public class PaginaCallbacks {

    /**
     * Quantidade total de páginas disponíveis para consulta.
     */
    @JsonProperty(value = "totalPaginas")
    private Integer totalPaginas;

    /**
     * Quantidade total de itens disponíveis de acordo com os parâmetros informados.
     */
    @JsonProperty(value = "totalElementos")
    private Integer totalElementos;

    /**
     * Última página
     */
    @JsonProperty(value = "ultimaPagina")
    private Boolean ultimaPagina;

    /**
     * Primeira página
     */
    @JsonProperty(value = "primeiraPagina")
    private Boolean primeiraPagina;

    /**
     * Quantidade de registros por página, configurado na requisição.
     */
    @JsonProperty(value = "tamanhoPagina")
    private Integer tamanhoPagina;

    /**
     * Quantidade de registros retornado na página atual.
     */
    @JsonProperty(value = "numeroDeElementos")
    private Integer numeroDeElementos;

    @JsonProperty(value = "data")
    private List<RespostaBuscarCallbacks> data;

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
