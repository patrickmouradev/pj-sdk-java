package inter.pix.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevolucaoHorario {

    private OffsetDateTime solicitacao;
    private OffsetDateTime liquidacao;

}

