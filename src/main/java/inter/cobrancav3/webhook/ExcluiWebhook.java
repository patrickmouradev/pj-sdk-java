package inter.cobrancav3.webhook;

import inter.exceptions.SdkException;
import inter.model.Config;
import inter.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import static inter.constants.Constants.ESCOPO_BOLETO_COBRANCA_WRITE;
import static inter.constants.Constants.URL_COBRANCAS_WEBHOOK;

@Slf4j
public class ExcluiWebhook {

    public void excluir(Config config) throws SdkException {
        log.info("ExcluirWebhook cobrançaV3 {}", config.getClientId());
        String url = URL_COBRANCAS_WEBHOOK.replace("AMBIENTE", config.getAmbiente());
        HttpUtils.callDelete(config, url, ESCOPO_BOLETO_COBRANCA_WRITE, "Erro ao excluir webhook");
    }

}