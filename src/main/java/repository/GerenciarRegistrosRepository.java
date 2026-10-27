package repository;

import domain.Registros;
import domain.RepositoryRegistrosInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GerenciarRegistrosRepository implements RepositoryRegistrosInterface {
    private Map<Integer, Registros> registros = new LinkedHashMap<>();

    @Override
    public void cadastrar(Registros registro) {
        registros.put(registro.getId(), registro);
    }

    @Override
    public void editar(Registros registro) {
        registros.put(registro.getId(), registro);
    }

    @Override
    public void excluir(int id) {

        registros.remove(id);
    }

    @Override
    public Registros buscar(int id) {

        return registros.get(id);
    }

    @Override
    public List<Registros> listarRegistros() {
        return new ArrayList<>(registros.values());
    }
}
