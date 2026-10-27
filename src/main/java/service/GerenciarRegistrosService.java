package service;

import domain.Registros;
import domain.ServiceRegistrosInterface;
import domain.TipoDeGasto;
import repository.GerenciarRegistrosRepository;
import util.GeradorId;
import util.ValidacoesRegistros;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GerenciarRegistrosService implements ServiceRegistrosInterface {

    private GeradorId geradorId = new GeradorId();
    private DecimalFormat df = new DecimalFormat("0.00");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ValidacoesRegistros validacoes = new ValidacoesRegistros();
    private GerenciarRegistrosRepository repository = new GerenciarRegistrosRepository();

    @Override
    public Registros cadastrar(String nome, String descricao, double valor, TipoDeGasto tipoDeGasto) {

        Registros novoRegistro = new Registros(geradorId.getId(), nome, descricao, valor, atualizarDataRegistro(), tipoDeGasto);

        // enviar para o repositorio
        repository.cadastrar(novoRegistro);

        return novoRegistro;
    }

    @Override
    public void editar(int id, String nome, String descricao, double valor, TipoDeGasto tipoDeGasto) {
        if(buscar(id) == null) {

        }

        validacoes.validarRegistros(nome, valor, tipoDeGasto);

        Registros editarRegistro = buscar(id);

        editarRegistro.setNome(nome);
        editarRegistro.setDescricao(descricao);
        editarRegistro.setValor(valor);
        editarRegistro.setTipoDeGasto(tipoDeGasto);
        editarRegistro.setDataRegistro(atualizarDataRegistro());

        // enviar para o repositorio
        repository.editar(editarRegistro);

    }

    @Override
    public void excluir(int id) {

        buscar(id);
        // chamar a exclusao do repositorio
        repository.excluir(id);
    }

    @Override
    public Registros buscar(int id) {

        if(id <= 0){
            throw new IllegalArgumentException(
                    "O ID precisa ser maior do que 0"
            );
        }

        Registros busca = repository.buscar(id);

        if (busca == null) {
            throw new IllegalArgumentException("Registro não encontrado!");
        }

        // chamar a busca do repositorio
        return busca;
    }

    @Override
    public List<Registros> listarRegistros() {

        // pegar a lista do repositorio
        return repository.listarRegistros();
    }

    private String atualizarDataRegistro(){
        return LocalDate.now().format(FORMATTER);
    }
}
