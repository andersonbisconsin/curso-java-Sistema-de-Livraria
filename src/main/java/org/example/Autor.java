package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento; // Usando LocalDate para datas

    // Formatter para exibir a data
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Autor(int id, String nome, String dataNascimentoStr) {
        this.id = id;
        this.nome = nome;
        // Converte a string de data para LocalDate
        try {
            this.dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ISO_LOCAL_DATE); // Espera formato YYYY-MM-DD
        } catch (Exception e) {
            System.err.println("Formato de data de nascimento inválido para o autor " + nome + ". Use YYYY-MM-DD.");
            this.dataNascimento = null; // Ou lançar uma exceção mais específica
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimentoFormatada() {
        if (dataNascimento != null) {
            return dataNascimento.format(DATE_FORMATTER);
        }
        return "N/A";
    }

    @Override
    public String toString() {
        return nome + " (Nasc.: " + getDataNascimentoFormatada() + ")";
    }
}