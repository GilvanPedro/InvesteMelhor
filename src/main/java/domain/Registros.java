package domain;

import util.ValidacoesRegistros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Registros {
    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private LocalDate dataRegistro;
    private TipoDeGasto tipoDeGasto;

    private ValidacoesRegistros validacoes = new ValidacoesRegistros();

    // Formatador estático para o padrão brasileiro DD/MM/AAAA
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Registros(int id, String nome, String descricao, double valor, String dataRegistro, TipoDeGasto tipoDeGasto) {

        validacoes.validarRegistros(nome, valor, tipoDeGasto);

        // Validação e Atribuição da Data de Nascimento
        try {
            this.dataRegistro = LocalDate.parse(dataRegistro, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido! Use o padrão DD/MM/AAAA.");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoDeGasto = tipoDeGasto;
    }

    public ValidacoesRegistros getValidacoes() {
        return validacoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getDataRegistro() {
        return dataRegistro.format(FORMATTER);      // 14/03/2006
    }

    public TipoDeGasto getTipoDeGasto() {
        return tipoDeGasto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
        this.tipoDeGasto = tipoDeGasto;
    }

    public void setDataRegistro(String dataRegistro) {
        try {
            this.dataRegistro = LocalDate.parse(dataRegistro, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido! Use o padrão DD/MM/AAAA.");
        }
    }

    @Override
    public String toString() {
        return "Registros{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + String.format("%.2f", valor) +
                ", dataRegistro=" + dataRegistro.format(FORMATTER) +
                ", tipoDeGasto=" + tipoDeGasto +
                ", validacoes=" + validacoes +
                '}';
    }
}
