package inter.pix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.cobrancav3.model.enums.OrigemRecebimento;
import inter.cobrancav3.model.enums.SituacaoCobranca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    private List<ItemPayload> pix;

}
