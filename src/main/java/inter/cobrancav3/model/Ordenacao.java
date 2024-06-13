package inter.cobrancav3.model;

import inter.cobrancav3.model.enums.OrdenadoPor;
import inter.cobrancav3.model.enums.TipoOrdenacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordenacao {
    private OrdenadoPor ordenarPor;
    private TipoOrdenacao tipoOrdenacao;
}