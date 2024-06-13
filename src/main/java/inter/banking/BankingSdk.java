package inter.banking;

import inter.banking.extrato.ConsultarExtrato;
import inter.banking.extrato.ConsultarExtratoEnriquecido;
import inter.banking.extrato.RecuperarExtratoPdf;
import inter.banking.model.Extrato;
import inter.banking.model.PaginaExtratoEnriquecido;
import inter.banking.model.FiltroBuscarPagamentos;
import inter.banking.model.FiltroBuscarPagamentosDarf;
import inter.banking.model.FiltroConsultarExtratoEnriquecido;
import inter.banking.model.ItemLote;
import inter.banking.model.Pagamento;
import inter.banking.model.PagamentoBoleto;
import inter.banking.model.PagamentoDarf;
import inter.banking.model.Pix;
import inter.banking.model.ProcessamentoLote;
import inter.banking.model.RespostaIncluirPagamento;
import inter.banking.model.RespostaIncluirPagamentoDarf;
import inter.banking.model.RespostaIncluirPagamentosLote;
import inter.banking.model.RespostaIncluirPix;
import inter.banking.model.RetornoPagamentoDarf;
import inter.banking.model.Saldo;
import inter.banking.model.TransacaoEnriquecida;
import inter.banking.model.FiltroBuscarCallbacks;
import inter.banking.model.Ordenacao;
import inter.banking.model.PaginaCallbacks;
import inter.banking.model.RespostaBuscarCallbacks;
import inter.banking.pagamento.BuscarLotePagamentos;
import inter.banking.pagamento.BuscarPagamentos;
import inter.banking.pagamento.BuscarPagamentosDarf;
import inter.banking.pagamento.CancelaAgendamentoPagamento;
import inter.banking.pagamento.IncluirPagamento;
import inter.banking.pagamento.IncluirPagamentoDarf;
import inter.banking.pagamento.IncluirPagamentosLote;
import inter.banking.pix.IncluirPix;
import inter.banking.saldo.ConsultarSaldo;
import inter.banking.webhook.ConsultarCallbacks;
import inter.banking.webhook.CriarWebhook;
import inter.banking.webhook.ExcluirWebhook;
import inter.banking.webhook.ObterWebhook;
import inter.exceptions.SdkException;
import inter.model.Config;
import inter.model.Webhook;

import java.util.List;

public class BankingSdk {
    private final Config config;
    private ConsultarExtrato consultarExtrato;
    private RecuperarExtratoPdf recuperarExtratoPdf;
    private ConsultarExtratoEnriquecido consultarExtratoEnriquecido;
    private ConsultarSaldo consultarSaldo;
    private IncluirPagamento incluirPagamento;
    private BuscarPagamentos buscarPagamentos;
    private CancelaAgendamentoPagamento cancelaAgendamentoPagamento;
    private IncluirPagamentoDarf incluirPagamentoDarf;
    private BuscarPagamentosDarf buscarPagamentosDarf;
    private IncluirPagamentosLote incluirPagamentosLote;
    private BuscarLotePagamentos buscarLotePagamentos;
    private IncluirPix incluirPix;
    private CriarWebhook criarWebhook;
    private ObterWebhook obterWebhook;
    private ExcluirWebhook excluirWebhook;
    private ConsultarCallbacks consultarCallbacks;

    public BankingSdk(Config config) {
        this.config = config;
    }

    /**
     * Consulta o extrato por um período específico. O período máximo entre as datas é de 90 dias.
     *
     * @param dataInicial Data início da consulta de extrato. Formato: YYYY-MM-DD.
     * @param dataFinal   Data fim da consulta de extrato. Formato: YYYY-MM-DD.
     * @return lista de transações
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extrato-1">Consultar extrato</a>
     */
    public Extrato consultarExtrato(String dataInicial, String dataFinal) throws SdkException {
        if (consultarExtrato == null) {
            consultarExtrato = new ConsultarExtrato();
        }

        return consultarExtrato.consultar(config, dataInicial, dataFinal);
    }

    /**
     * Recupera o extrato em pdf por um período específico. O período máximo entre as datas é de 90 dias.
     *
     * @param dataInicial Data inicio da exportação de extrato. Formato: YYYY-MM-DD.
     * @param dataFinal   Data fim da exportação de extrato. Formato: YYYY-MM-DD.
     * @param arquivo     Arquivo PDF que será gravado.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratoexport">Recuperar extrato em PDF</a>
     */
    public void recuperarExtratoPdf(String dataInicial, String dataFinal, String arquivo) throws SdkException {
        if (recuperarExtratoPdf == null) {
            recuperarExtratoPdf = new RecuperarExtratoPdf();
        }

        recuperarExtratoPdf.recuperar(config, dataInicial, dataFinal, arquivo);
    }

    /**
     * Consulta extrato enriquecido num intervalo de datas com os filtros especificados
     *
     * @param dataInicial data inicial para consulta. Formato: YYYY-MM-DD.
     * @param dataFinal   data final para consulta. Formato: YYYY-MM-DD.
     * @param filtro      filtros para consulta(opcional, pode ser null)
     * @return lista de transações enriquecidas
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete">Consultar extrato enriquecido</a>
     */
    public List<TransacaoEnriquecida> consultarExtratoEnriquecido(String dataInicial, String dataFinal, FiltroConsultarExtratoEnriquecido filtro) throws SdkException {
        if (consultarExtratoEnriquecido == null) {
            consultarExtratoEnriquecido = new ConsultarExtratoEnriquecido();
        }

        return consultarExtratoEnriquecido.consultar(config, dataInicial, dataFinal, filtro);
    }

    /**
     * Consulta extrato enriquecido com informações detalhadas de cada transação dado um período específico. O período máximo entre as datas é de 90 dias.
     *
     * @param dataInicial Data início da exportação de extrato. Formato: YYYY-MM-DD.
     * @param dataFinal   Data fim da exportação de extrato. Formato: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @param pagina      Número da página iniciando com 0.
     * @return lista de transações enriquecidas
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete-1">Consultar extrato enriquecido</a>
     */
    public PaginaExtratoEnriquecido consultarExtratoEnriquecido(String dataInicial, String dataFinal, FiltroConsultarExtratoEnriquecido filtro, int pagina) throws SdkException {
        if (consultarExtratoEnriquecido == null) {
            consultarExtratoEnriquecido = new ConsultarExtratoEnriquecido();
        }

        return consultarExtratoEnriquecido.consultar(config, dataInicial, dataFinal, pagina, null, filtro);
    }

    /**
     * Consulta extrato enriquecido com informações detalhadas de cada transação dado um período específico. O período máximo entre as datas é de 90 dias.
     *
     * @param dataInicial   Data início da exportação de extrato. Formato: YYYY-MM-DD.
     * @param dataFinal     Data fim da exportação de extrato. Formato: YYYY-MM-DD.
     * @param filtro        Filtros para consulta(opcional, pode ser null).
     * @param pagina        Número da página iniciando com 0.
     * @param tamanhoPagina Tamanho da páfina, padrão = 50.
     * @return lista de transações enriquecidas
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete-1">Consultar extrato enriquecido</a>
     */
    public PaginaExtratoEnriquecido consultarExtratoEnriquecido(String dataInicial, String dataFinal, FiltroConsultarExtratoEnriquecido filtro,
                                                                int pagina, int tamanhoPagina) throws SdkException {
        if (consultarExtratoEnriquecido == null) {
            consultarExtratoEnriquecido = new ConsultarExtratoEnriquecido();
        }

        return consultarExtratoEnriquecido.consultar(config, dataInicial, dataFinal, pagina, tamanhoPagina, filtro);
    }

    /**
     * Consulta o saldo atual.
     *
     * @return objeto com os saldos atuais da conta
     * @see <a href="https://developers.bancointer.com.br/v4/reference/saldo-3">Consultar saldo</a>
     */
    public Saldo consultarSaldo() throws SdkException {
        if (consultarSaldo == null) {
            consultarSaldo = new ConsultarSaldo();
        }

        return consultarSaldo(null);
    }

    /**
     * Consulta o saldo por um período específico.
     *
     * @param dataSaldo Data de consulta para o saldo posicional. Formato: YYYY-MM-DD.
     * @return objeto com os saldos da conta na data especificada
     * @see <a href="https://developers.bancointer.com.br/v4/reference/saldo-1">Consultar saldo</a>
     */
    public Saldo consultarSaldo(String dataSaldo) throws SdkException {
        if (consultarSaldo == null) {
            consultarSaldo = new ConsultarSaldo();
        }

        return consultarSaldo.consultar(config, dataSaldo);
    }

    /**
     * Método para inclusão de um pagamento imediato ou agendamento do pagamento de boleto, convênio ou tributo com código de barras.
     *
     * @param pagamento Dados do pagamento
     * @return objeto com quantidadeAprovadores, statusPagamento, codigoTransacao...
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagarboleto">Incluir pagamento com código de barras</a>
     */
    public RespostaIncluirPagamento incluirPagamento(PagamentoBoleto pagamento) throws SdkException {
        if (incluirPagamento == null) {
            incluirPagamento = new IncluirPagamento();
        }

        return incluirPagamento.incluir(config, pagamento);
    }

    /**
     * Busca informações de pagamentos de boleto.
     *
     * @param dataInicial Data inicio, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal   Data Fim, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @return lista de pagamentos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentos">Buscar pagamentos</a>
     */
    public List<Pagamento> buscarPagamentos(String dataInicial, String dataFinal, FiltroBuscarPagamentos filtro) throws SdkException {
        if (buscarPagamentos == null) {
            buscarPagamentos = new BuscarPagamentos();
        }

        return buscarPagamentos.buscar(config, dataInicial, dataFinal, filtro);
    }

    /**
     * Método para inclusão de um pagamento imediato de DARF sem código de barras.
     *
     * @param pagamento Dados do pagamento
     * @return objeto com autenticacao, nroOperacao, tipoRetorno, codigoTransacao...
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagamentosdarf-1">Incluir pagamento de DARF</a>
     */
    public RespostaIncluirPagamentoDarf incluirPagamentoDarf(PagamentoDarf pagamento) throws SdkException {
        if (incluirPagamentoDarf == null) {
            incluirPagamentoDarf = new IncluirPagamentoDarf();
        }

        return incluirPagamentoDarf.incluir(config, pagamento);
    }

    /**
     * Busca informações de pagamento de DARF.
     *
     * @param dataInicial Data inicio, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param dataFinal   Data Fim, em acordo com o campo "filtrarDataPor". Formato aceito: YYYY-MM-DD.
     * @param filtro      Filtros para consulta(opcional, pode ser null).
     * @return lista de pagamentos
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentodarf">Buscar pagamentos de DARF</a>
     */
    public List<RetornoPagamentoDarf> buscarPagamentosDarf(String dataInicial, String dataFinal, FiltroBuscarPagamentosDarf filtro) throws SdkException {
        if (buscarPagamentosDarf == null) {
            buscarPagamentosDarf = new BuscarPagamentosDarf();
        }

        return buscarPagamentosDarf.buscar(config, dataInicial, dataFinal, filtro);
    }

    /**
     * Inclusão de um lote de pagamentos digitados pelo cliente
     *
     * @param meuIdentificador Identificador do lote para o cliente.
     * @param pagamentos       Pagamentos a serem efetuados.
     * @return informações do processamento do lote
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagamentoslote">Incluir pagamentos em lote</a>
     */
    public RespostaIncluirPagamentosLote incluirPagamentosLote(String meuIdentificador, List<ItemLote> pagamentos) throws SdkException {
        if (incluirPagamentosLote == null) {
            incluirPagamentosLote = new IncluirPagamentosLote();
        }

        return incluirPagamentosLote.incluir(config, meuIdentificador, pagamentos);
    }

    /**
     * Inclusão de um lote de pagamentos digitados pelo cliente
     *
     * @param idLote Identificador do lote.
     * @return informações do processamento do lote
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentolote">Buscar lote de pagamentos</a>
     */
    public ProcessamentoLote buscarLotePagamentos(String idLote) throws SdkException {
        if (buscarLotePagamentos == null) {
            buscarLotePagamentos = new BuscarLotePagamentos();
        }

        return buscarLotePagamentos.buscar(config, idLote);
    }

    /**
     * Método para inclusão de um pagamento/transferência Pix utilizando dados bancários ou chave.
     *
     * @param pix Dados do pix
     * @return objeto com endToEndId...
     * @see <a href="https://developers.bancointer.com.br/v4/reference/realizarpagamentopix-1">Incluir Pix</a>
     */
    public RespostaIncluirPix incluirPix(Pix pix) throws SdkException {
        if (incluirPix == null) {
            incluirPix = new IncluirPix();
        }

        return incluirPix.incluir(config, pix);
    }

    /**
     * Método destinado a criar um webhook para receber notificações de confirmação de envio de pix (callbacks).
     *
     * @param webhookUrl A URL do servidor https do cliente
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookput">Criar webhook</a>
     */
    public void criarWebhook(String tipoWebhook, String webhookUrl) throws SdkException {
        if (criarWebhook == null) {
            criarWebhook = new CriarWebhook();
        }

        criarWebhook.criar(config, tipoWebhook, webhookUrl);
    }

    /**
     * Obter webhook cadastrado
     *
     * @return webhook
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookget-3">Obter webhook cadastrado</a>
     */
    public Webhook obterWebhook(String tipoWebhook) throws SdkException {
        if (obterWebhook == null) {
            obterWebhook = new ObterWebhook();
        }
        return obterWebhook.obter(config, tipoWebhook);
    }

    /**
     * Exclui o webhook
     *
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookdelete-3">Excluir webhook</a>
     */
    public void excluirWebhook(String tipoWebhook) throws SdkException {
        if (excluirWebhook == null) {
            excluirWebhook = new ExcluirWebhook();
        }
        excluirWebhook.excluir(config, tipoWebhook);
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
    public List<RespostaBuscarCallbacks> consultarCallbacks(String tipoWebhook, String dataHoraInicio, String dataHoraFim, FiltroBuscarCallbacks filtro, Ordenacao ordenacao) throws SdkException {
        if (consultarCallbacks == null) {
            consultarCallbacks = new ConsultarCallbacks();
        }

        return consultarCallbacks.recuperar(config, tipoWebhook, dataHoraInicio, dataHoraFim, filtro);
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
    public PaginaCallbacks consultarCallbacks(String tipoWebhook, String dataHoraInicio, String dataHoraFim, FiltroBuscarCallbacks filtro, int pagina, Ordenacao ordenacao) throws SdkException {
        if (consultarCallbacks == null) {
            consultarCallbacks = new ConsultarCallbacks();
        }

        return consultarCallbacks.recuperar(config, tipoWebhook, dataHoraInicio, dataHoraFim, pagina, null, filtro);
    }

    /**
     * Cancela o agendamento de um pagamento.
     *
     * @param codigoTransacao Código único da transacação
     * @throws SdkException
     */
    public void cancelaAgendamentoPagamento(String codigoTransacao) throws  SdkException {
        if(cancelaAgendamentoPagamento == null){
            cancelaAgendamentoPagamento = new CancelaAgendamentoPagamento();
        }
        cancelaAgendamentoPagamento.cancelar(config, codigoTransacao);
    }

}
