package util;

import domain.TipoDeGasto;

public class ValidacoesRegistros {
    public void validarRegistros(String nome, double valor, TipoDeGasto tipoDeGasto){
        validarNome(nome);
        validarValor(valor);
        validarTipoDeGasto(tipoDeGasto);
    }

    private void validarNome(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException(
                    "Nome inválido, verifique se ele foi digitado corretamente"
            );
        }
    }

    private void validarValor(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException(
                    "Valor inválido, insira um valor maior do que 0"
            );
        }
    }

    private void validarTipoDeGasto(TipoDeGasto tipoDeGasto){
        if(tipoDeGasto == null){
            throw new IllegalArgumentException(
                    "O tipo de gasto não pode estar vazio"
            );
        }
    }

}
