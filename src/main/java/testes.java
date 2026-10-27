import domain.Registros;
import domain.TipoDeGasto;
import service.GerenciarRegistrosService;

import java.time.LocalDate;

public class testes {
    public static void main(String[] args) {
        GerenciarRegistrosService gerador = new GerenciarRegistrosService();

        Registros teste = gerador.cadastrar("asdfas", "sadfsdf", 23.726, TipoDeGasto.FIXO);

        System.out.println(teste.toString());

        Registros buscado = gerador.buscar(1);

        System.out.println("Registro buscado: ");
        System.out.println(buscado.toString());
    }
}
