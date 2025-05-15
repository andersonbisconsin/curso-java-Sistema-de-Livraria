package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true; // Por padrão, o livro está disponível ao ser cadastrado
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        this.dataAtualizacao = LocalDate.now(); // Atualiza a data de modificação
    }

    public String getDataCadastroFormatada() {
        return dataCadastro.format(DATE_FORMATTER);
    }

    public String getDataAtualizacaoFormatada() {
        return dataAtualizacao.format(DATE_FORMATTER);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\n  Título: " + titulo +
                "\n  Autor: " + autor.getNome() +
                "\n  Disponível: " + (disponivel ? "Sim" : "Não") +
                "\n  Data de Cadastro: " + getDataCadastroFormatada() +
                "\n  Última Atualização: " + getDataAtualizacaoFormatada();
    }
}