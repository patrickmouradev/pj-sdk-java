package inter.cobrancav3.cobranca;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.cobrancav3.model.RequisicaoEmitirCobranca;
import inter.cobrancav3.model.RespostaEmitirCobranca;
import inter.exceptions.SdkException;
import inter.model.Config;
import inter.model.Erro;
import inter.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static inter.constants.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.constants.Constants.ESCOPO_BOLETO_COBRANCA_WRITE;
import static inter.constants.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.constants.Constants.URL_COBRANCAS;

@Slf4j
public class EmiteCobranca {

    public RespostaEmitirCobranca emitir(Config config, RequisicaoEmitirCobranca requisicaoEmitirCobranca) throws SdkException {
        log.info("EmitirCobranca {} {}", config.getClientId(), requisicaoEmitirCobranca.getSeuNumero());
        String url = URL_COBRANCAS.replace("AMBIENTE", config.getAmbiente());
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requisicaoEmitirCobranca);
            json = HttpUtils.callPost(config, url, ESCOPO_BOLETO_COBRANCA_WRITE, "Erro ao emitir cobrança", json);
            return new ObjectMapper().readValue(json, RespostaEmitirCobranca.class);
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Erro.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE).
                            detail(ioException.getMessage())
                            .build()
            );
        }
    }

}