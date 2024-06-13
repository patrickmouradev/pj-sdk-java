package inter.exceptions;

import inter.model.Erro;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SdkException extends Exception {
    private final Erro erro;

    public SdkException(String mensagem, Erro erro) {
        super(mensagem);
        this.erro = erro;
    }
}
