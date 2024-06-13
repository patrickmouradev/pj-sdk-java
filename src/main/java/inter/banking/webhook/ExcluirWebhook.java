package inter.banking.webhook;

import inter.exceptions.SdkException;
import inter.model.Config;
import inter.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import static inter.constants.Constants.*;

@Slf4j
public class ExcluirWebhook {

    public void excluir(Config config, String tipoWebhook) throws SdkException {
        log.info("ExcluirWebhook banking {} {}", config.getClientId(), tipoWebhook);
        String url = URL_BANKING_WEBHOOK.replace("AMBIENTE", config.getAmbiente()) + "/" + tipoWebhook;

        HttpUtils.callDelete(config, url, ESCOPO_BANKING_WEBHOOK_BANKING_WRITE, "Erro ao excluir webhook");
    }

}