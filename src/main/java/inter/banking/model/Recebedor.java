package inter.banking.model;

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
public class Recebedor {

    private String codAgencia;
    private String codIspb;
    private String cpfCnpj;
    private String nome;
    private String nroConta;
    private String tipoConta;

}
