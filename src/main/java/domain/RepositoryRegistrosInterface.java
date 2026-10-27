package domain;

import java.util.List;

public interface RepositoryRegistrosInterface {
    public void cadastrar(Registros registro);
    public void editar(Registros registro);
    public void excluir(int id);
    public Registros buscar(int id);
    public List<Registros> listarRegistros();
}
