package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrancaRecuperada {

    private RespostaRecuperarCobrancaCobranca cobranca;
    private RespostaRecuperarCobrancaBoleto boleto;
    private RespostaRecuperarCobrancaPix pix;

}