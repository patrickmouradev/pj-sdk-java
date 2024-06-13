package inter.constants;

public class Constants {

    private Constants() {
    }
    private static final String URL_BASE = "https://cdpj.partners.AMBIENTE.com.br";
    public static final String DOC_CERTIFICADO = "https://developers.bancointer.com.br/v4/docs/onde-obter-o-certificado";

    public static final String URL_TOKEN = URL_BASE + "/oauth/v2/token";

    public static final String URL_BANKING = URL_BASE + "/banking/v2";
    public static final String URL_BANKING_SALDO = URL_BANKING + "/saldo";
    public static final String URL_BANKING_EXTRATO = URL_BANKING + "/extrato";
    public static final String URL_BANKING_EXTRATO_ENRIQUECIDO = URL_BANKING_EXTRATO + "/completo";
    public static final String URL_BANKING_EXTRATO_PDF = URL_BANKING_EXTRATO + "/exportar";
    public static final String URL_BANKING_PAGAMENTO = URL_BANKING + "/pagamento";
    public static final String URL_BANKING_PAGAMENTO_DARF = URL_BANKING_PAGAMENTO + "/darf";
    public static final String URL_BANKING_PAGAMENTO_LOTE = URL_BANKING_PAGAMENTO + "/lote";
    public static final String URL_BANKING_PAGAMENTO_PIX = URL_BANKING + "/pix";
    public static final String URL_BANKING_TED = URL_BANKING + "/ted";
    public static final String URL_BANKING_WEBHOOK = URL_BANKING + "/webhooks";


    public static final String URL_PIX = URL_BASE + "/pix/v2";
    public static final String URL_PIX_PIX = URL_PIX + "/pix";
    public static final String URL_PIX_LOCATIONS = URL_PIX + "/loc";
    public static final String URL_PIX_COBRANCAS_IMEDIATAS = URL_PIX + "/cob";
    public static final String URL_PIX_COBRANCA_COM_VENCIMENTO = URL_PIX + "/cobv";
    public static final String URL_PIX_WEBHOOK = URL_PIX + "/webhook";
    public static final String URL_PIX_WEBHOOK_CALLBACKS = URL_PIX_WEBHOOK + "/callbacks";

    public static final String URL_BOLETOS = URL_BASE + "/cobranca/v2/boletos";
    public static final String URL_BOLETOS_SUMARIO = URL_BOLETOS + "/sumario";
    public static final String URL_BOLETOS_WEBHOOK = URL_BOLETOS + "/webhook";
    public static final String URL_BOLETOS_WEBHOOK_CALLBACKS = URL_BOLETOS_WEBHOOK + "/callbacks";
    public static final String URL_COBRANCAS = URL_BASE + "/cobranca/v3/cobrancas";
    public static final String URL_COBRANCAS_SUMARIO = URL_COBRANCAS + "/sumario";
    public static final String URL_COBRANCAS_WEBHOOK = URL_COBRANCAS + "/webhook";
    public static final String URL_COBRANCAS_WEBHOOK_CALLBACKS = URL_COBRANCAS_WEBHOOK + "/callbacks";

    public static final String ESCOPO_BOLETO_COBRANCA_READ = "boleto-cobranca.read";
    public static final String ESCOPO_BOLETO_COBRANCA_WRITE = "boleto-cobranca.write";

    public static final String ESCOPO_EXTRATO_READ = "extrato.read";
    public static final String ESCOPO_PAGAMENTO_BOLETO_READ = "pagamento-boleto.read";
    public static final String ESCOPO_PAGAMENTO_BOLETO_WRITE = "pagamento-boleto.write";
    public static final String ESCOPO_PAGAMENTO_DARF_WRITE = "pagamento-darf.write";
    public static final String ESCOPO_PAGAMENTOS_LOTE_READ= "pagamento-lote.read";
    public static final String ESCOPO_PAGAMENTOS_LOTE_WRITE = "pagamento-lote.write";
    public static final String ESCOPO_PAGAMENTO_PIX_WRITE = "pagamento-pix.write";
    public static final String ESCOPO_BANKING_WEBHOOK_BANKING_READ = "webhook-banking.read";
    public static final String ESCOPO_BANKING_WEBHOOK_BANKING_WRITE = "webhook-banking.write";

    public static final String ESCOPO_PIX_COB_READ = "cob.read";
    public static final String ESCOPO_PIX_COB_WRITE = "cob.write";
    public static final String ESCOPO_PIX_COBV_READ = "cobv.read";
    public static final String ESCOPO_PIX_COBV_WRITE = "cobv.write";
    public static final String ESCOPO_PIX_PIX_READ = "pix.read";
    public static final String ESCOPO_PIX_PIX_WRITE = "pix.write";
    public static final String ESCOPO_PIX_LOCATION_READ = "payloadlocation.read";
    public static final String ESCOPO_PIX_LOCATION_WRITE = "payloadlocation.write";
    public static final String ESCOPO_PIX_WEBHOOK_READ = "webhook.read";
    public static final String ESCOPO_PIX_WEBHOOK_WRITE = "webhook.write";

    public static final int DAYS_TO_EXPIRE = 30;

    public static final String CERTIFICATE_EXCEPTION_MESSAGE = "Erro no Certificado!";
    public static final String GENERIC_EXCEPTION_MESSAGE = "Erro durante execução do SDK!";

}