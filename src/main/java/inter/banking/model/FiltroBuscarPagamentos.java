package inter.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.banking.model.enums.TipoDataPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FiltroBuscarPagamentos {

    private String codBarraLinhaDigitavel;
    private String codigoTransacao;
    private TipoDataPagamento filtrarDataPor;

}
