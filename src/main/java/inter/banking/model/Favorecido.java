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
public class Favorecido implements Destinatario {

    private String id;
    /**
     * <p>REQUERIDO</p>
     */
    private String nome;

    private String cpfCnpj;

    /**
     * REQUERIDO
     */
    private InstituicaoFinanceira instituicaoFinanceira;

    /**
     * <p>REQUERIDO</p>
     */
    private String agencia;

    /**
     * <p>REQUERIDO</p>
     */
    private String conta;

    private String email;

    private String descricao;

}