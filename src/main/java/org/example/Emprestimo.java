package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Livro livro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Emprestimo(Livro livro, String nomeUsuario) {
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getDataEmprestimoFormatada() {
        // Para incluir hora, precisaríamos de LocalDateTime, mas para simplificar:
        return dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return "Empréstimo:" +
                "\n  Livro: '" + livro.getTitulo() + "' por " + livro.getAutor().getNome() +
                "\n  Usuário: " + nomeUsuario +
                "\n  Data do Empréstimo: " + getDataEmprestimoFormatada();
    }
}
