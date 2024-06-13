package inter.banking.model;

import inter.banking.model.enums.TipoOperacao;
import inter.banking.model.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroConsultarExtratoEnriquecido {

    private TipoOperacao tipoOperacao;
    private TipoTransacao tipoTransacao;

}