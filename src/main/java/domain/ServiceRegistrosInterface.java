package domain;

import java.time.LocalDate;
import java.util.List;

public interface ServiceRegistrosInterface {
    public Registros cadastrar(String nome, String descricao, double valor, TipoDeGasto tipoDeGasto);
    public void editar(int id, String nome, String descricao, double valor, TipoDeGasto tipoDeGasto);
    public void excluir(int id);
    public Registros buscar(int id);
    public List<Registros> listarRegistros();
}
