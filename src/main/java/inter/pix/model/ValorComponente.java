package inter.pix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorComponente {

    private String valor;
    private String modalidadeAgente;
    private String prestadorDoServicoDeSaque;

}
