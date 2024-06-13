package inter.cobrancav3;

import inter.cobrancav3.cobranca.CancelaCobranca;
import inter.cobrancav3.cobranca.EmiteCobranca;
import inter.cobrancav3.cobranca.RecuperaCobranca;
import inter.cobrancav3.cobranca.RecuperaCobrancaPdf;
import inter.cobrancav3.cobranca.RecuperaColecaoCobrancas;
import inter.cobrancav3.cobranca.RecuperaSumarioCobrancas;
import inter.cobrancav3.model.FiltroBuscarCallbacks;
import inter.cobrancav3.model.FiltroRecuperarCobrancas;
import inter.cobrancav3.model.FiltroRecuperarSumarioCobrancas;
import inter.cobrancav3.model.Ordenacao;
import inter.cobrancav3.model.PaginaCallbacks;
import inter.cobrancav3.model.PaginaCobrancas;
import inter.cobrancav3.model.RequisicaoEmitirCobranca;
import inter.cobrancav3.model.RespostaEmitirCobranca;
import inter.cobrancav3.model.CobrancaRecuperada;
import inter.cobrancav3.model.RespostaBuscarCallbacks;
import inter.cobrancav3.model.Sumario;
import inter.cobrancav3.webhook.ConsultaCallbacks;
import inter.cobrancav3.webhook.CriaWebhook;
import inter.cobrancav3.webhook.ExcluiWebhook;
import inter.cobrancav3.webhook.ObtemWebhook;
import inter.exceptions.SdkException;
import inter.model.Config;
import inter.model.Webhook;

import java.util.List;

public class CobrancaV3Sdk {
    private final Config config;
    private CancelaCobranca cancelaCobranca;
    private EmiteCobranca emiteCobranca;
    private RecuperaCobranca recuperaCobranca;
    private RecuperaColecaoCobrancas recuperaColecaoCobrancas;
    private RecuperaCobrancaPdf recuperaCobrancaPdf;
    private RecuperaSumarioCobrancas recuperaSumarioCobrancas;
    private CriaWebhook criaWebhook;
    private ObtemWebhook obtemWebhook;
    private ExcluiWebhook excluiWebhook;
    private ConsultaCallbacks consultaCallbacks;

    public CobrancaV3Sdk(Config config) {
        this.config = config;
    }

    /**
     * Cancela uma cobrança.
     *
     * @param codigoSolicitacao  Código de solicitação da cobrança
     * @param motivoCancelamento Texto livre com o motivo do cancelamento sendo solicitado.
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/cancelarCobranca">Cancelar cobrança</a>
     */
    public void cancelarCobranca(String codigoSolicitacao, String motivoCancelamento) throws SdkException {
        if (cancelaCobranca == null) {
            cancelaCobranca = new CancelaCobranca();
        }
        cancelaCobranca.cancelar(config, codigoSolicitacao, motivoCancelamento);
    }

    /**
     * Emite uma nova Cobrança.
     * <p>A cobrança emitida estará disponível para consulta e pagamento, após um tempo apróximado de 5
     * minutos da sua inclusão. Esse tempo é necessário para o registro do boleto na CIP.</p>
     *
     * @param cobranca Dados da cobranca a ser emitida
     * @return objeto com codigoSolicitacao
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/emitirCobrancaAsync">Emitir cobrança</a>
     */
    public RespostaEmitirCobranca emitirCobranca(RequisicaoEmitirCobranca cobranca) throws SdkException {
        if (emiteCobranca == null) {
            emiteCobranca = new EmiteCobranca();
        }

        return emiteCobranca.emitir(config, cobranca);
    }

    /**
     * Recupera uma cobrança de acordo com o parâmetro codigoSolicitacao informado.
     *
     * @param codigoSolicitacao Códido da solicitação de emissao da cobrança.
     * @return Cobrança detalhada
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/recuperarCobrancaDetalhada">Recuperar cobrança detalhado</a>
     */
    public CobrancaRecuperada recuperarCobranca(String codigoSolicitacao) throws SdkException {
        if (recuperaCobranca == null) {
            recuperaCobranca = new RecuperaCobranca();
        }

        return recuperaCobranca.recuperar(config, codigoSolicitacao);
    }

    /**
     * Recupera uma coleção de Boletos por um período específico, de acordo com os parâmetros informados, com paginação.
     *
     * @param dataInicial Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal   Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @param ordenacao   Ordenação do resultado(opcional, pode ser null).
     * @return página com lista de boletos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Recuperar coleção de boletos</a>
     */
    public List<CobrancaRecuperada> recuperarCobrancas(String dataInicial, String dataFinal, FiltroRecuperarCobrancas filtro, Ordenacao ordenacao) throws SdkException {
        if (recuperaColecaoCobrancas == null) {
            recuperaColecaoCobrancas = new RecuperaColecaoCobrancas();
        }

        return recuperaColecaoCobrancas.recuperar(config, dataInicial, dataFinal, filtro, ordenacao);
    }

    /**
     * Recupera uma coleção de Boletos por um período específico, de acordo com os parâmetros informados, com paginação.
     *
     * @param dataInicial Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal   Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @param ordenacao   Ordenação do resultado(opcional, pode ser null).
     * @return página com lista de boletos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Recuperar coleção de boletos</a>
     */
    public PaginaCobrancas recuperarCobrancas(String dataInicial, String dataFinal, FiltroRecuperarCobrancas filtro, int pagina, Ordenacao ordenacao) throws SdkException {
        if (recuperaColecaoCobrancas == null) {
            recuperaColecaoCobrancas = new RecuperaColecaoCobrancas();
        }

        return recuperaColecaoCobrancas.recuperar(config, dataInicial, dataFinal, pagina, null, filtro, ordenacao);
    }

    /**
     * Recupera uma coleção de Cobranças por um período específico, de acordo com os parâmetros informados, com paginação.
     *
     * @param dataInicial   Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal     Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro        Filtros para consulta(opcional, pode ser null).
     * @param ordenacao     Ordenação do resultado(opcional, pode ser null).
     * @param pagina        Número da página iniciando com 0
     * @param tamanhoPagina Tamanho da página, padrão = 100.
     * @return página com lista de Cobranças
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/pesquisaCobranca">Recuperar coleção de Cobranças</a>
     */
    public PaginaCobrancas recuperarCobrancas(String dataInicial, String dataFinal, FiltroRecuperarCobrancas filtro, Ordenacao ordenacao, int pagina, int tamanhoPagina) throws SdkException {
        if (recuperaColecaoCobrancas == null) {
            recuperaColecaoCobrancas = new RecuperaColecaoCobrancas();
        }

        return recuperaColecaoCobrancas.recuperar(config, dataInicial, dataFinal, pagina, tamanhoPagina, filtro, ordenacao);
    }

    /**
     * Recupera uma cobrança em pdf de acordo com o parâmetro codigoSolicitacao informado.
     *
     * @param codigoSolicitacao Código da Solicitacao associada à cobrança.
     * @param arquivo     Arquivo PDF que será gravado
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/obterPdfCobranca>Recuperar cobrança em PDF</a>
     */
    public void recuperarCobrancaPdf(String codigoSolicitacao, String arquivo) throws SdkException {
        if (recuperaCobrancaPdf == null) {
            recuperaCobrancaPdf = new RecuperaCobrancaPdf();
        }
        recuperaCobrancaPdf.recuperar(config, codigoSolicitacao, arquivo);
    }

    /**
     * Recupera o sumário de uma coleção de cobranças por um período específico, de acordo com os parâmetros informados.
     *
     * @param dataInicial Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal   Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @return sumário
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Cobranca/operation/consultarSumario">Recuperar sumário de cobranças</a>
     */
    public Sumario recuperarSumarioCobrancas(String dataInicial, String dataFinal, FiltroRecuperarSumarioCobrancas filtro) throws SdkException {
        if (recuperaSumarioCobrancas == null) {
            recuperaSumarioCobrancas = new RecuperaSumarioCobrancas();
        }

        return recuperaSumarioCobrancas.recuperar(config, dataInicial, dataFinal, filtro);
    }

    /**
     * Método destinado a criar um webhook para receber notificações de cobranças pagos e cancelados (callbacks)
     *
     * @param webhookUrl
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Webhook/operation/webhookPut">Criar webhook</a>
     */
    public void criarWebhook(String webhookUrl) throws SdkException {
        if (criaWebhook == null) {
            criaWebhook = new CriaWebhook();
        }
        criaWebhook.criar(config, webhookUrl);
    }

    /**
     * Obter webhook cadastrado
     *
     * @return webhook
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Webhook/operation/webhookGet">Obter webhook cadastrado</a>
     */
    public Webhook obterWebhook() throws SdkException {
        if (obtemWebhook == null) {
            obtemWebhook = new ObtemWebhook();
        }

        return obtemWebhook.obter(config);
    }

    /**
     * Exclui o webhook
     *
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Webhook/operation/webhookDelete">Excluir webhook</a>
     */
    public void excluirWebhook() throws SdkException {
        if (excluiWebhook == null) {
            excluiWebhook = new ExcluiWebhook();
        }
        excluiWebhook.excluir(config);
    }

    /**
     * Consulta a lista de callbackspor um período específico, de acordo com os parâmetros informados, com paginação.
     *
     * @param dataHoraInicio   Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataHoraFim     Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro        Filtros para consulta(opcional, pode ser null).
     * @param pagina        Número da página, iniciando com 0
     * @param tamanhoPagina Tamanho da página, padrão = 100.
     * @return página com lista de Cobranças
     * @see <a href="https://developers.inter.co/references/cobranca-bolepix#tag/Webhook/operation/callbacksFilter">Recuperar coleção de Cobranças</a>
     */
    public PaginaCallbacks consultarCallbacks(String dataHoraInicio, String dataHoraFim, FiltroBuscarCallbacks filtro, int pagina, int tamanhoPagina) throws SdkException {
        if (consultaCallbacks == null) {
            consultaCallbacks = new ConsultaCallbacks();
        }

        return consultaCallbacks.recuperar(config, dataHoraInicio, dataHoraFim, pagina, tamanhoPagina, filtro);
    }

    /**
     * Recupera uma coleção de callbacks por um período específico, de acordo com os parâmetros informados, sem paginação.
     *
     * @param dataHoraInicio Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataHoraFim    Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro         Filtros para consulta(opcional, pode ser null).
     * @param ordenacao      Ordenação do resultado(opcional, pode ser null).
     * @return página com lista de boletos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Recuperar coleção de boletos</a>
     */
    public List<RespostaBuscarCallbacks> consultarCallbacks(String dataHoraInicio, String dataHoraFim, FiltroBuscarCallbacks filtro, Ordenacao ordenacao) throws SdkException {
        if (consultaCallbacks == null) {
            consultaCallbacks = new ConsultaCallbacks();
        }

        return consultaCallbacks.recuperar(config, dataHoraInicio, dataHoraFim, filtro);
    }

    /**
     * Recupera uma coleção de Boletos por um período específico, de acordo com os parâmetros informados, com paginação.
     *
     * @param dataHoraInicio Data inicial, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataHoraFim    Data final, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro         Filtros para consulta(opcional, pode ser null).
     * @param ordenacao      Ordenação do resultado(opcional, pode ser null).
     * @return página com lista de boletos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Recuperar coleção de boletos</a>
     */
    public PaginaCallbacks consultarCallbacks(String dataHoraInicio, String dataHoraFim, FiltroBuscarCallbacks filtro, int pagina, Ordenacao ordenacao) throws SdkException {
        if (consultaCallbacks == null) {
            consultaCallbacks = new ConsultaCallbacks();
        }

        return consultaCallbacks.recuperar(config, dataHoraInicio, dataHoraFim, pagina, null, filtro);
    }

}
