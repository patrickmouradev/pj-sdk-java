package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaRecuperarCobrancaBoleto {

    private String nossoNumero;
    private String codigoBarras;
    private String linhaDigitavel;

}