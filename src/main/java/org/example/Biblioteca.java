package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    public List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Método para pré-cadastrar autores e livros
    public void inicializarDados() {
        // Criando autores
        Autor autor1 = new Autor(1, "Machado de Assis", "1839-06-21");
        Autor autor2 = new Autor(2, "José de Alencar", "1829-05-01");
        Autor autor3 = new Autor(3, "Clarice Lispector", "1920-12-10");
        Autor autor4 = new Autor(4, "J.K. Rowling", "1965-07-31");
        Autor autor5 = new Autor(5, "George Orwell", "1903-06-25");

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        // Criando e adicionando livros
        livros.add(new Livro(101, "Dom Casmurro", autor1));
        livros.add(new Livro(102, "Memórias Póstumas de Brás Cubas", autor1));
        livros.add(new Livro(201, "Iracema", autor2));
        livros.add(new Livro(202, "Senhora", autor2));
        livros.add(new Livro(301, "A Hora da Estrela", autor3));
        livros.add(new Livro(401, "Harry Potter e a Pedra Filosofal", autor4));
        livros.add(new Livro(501, "1984", autor5));
        livros.add(new Livro(502, "A Revolução dos Bichos", autor5));
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\n--- Livros Disponíveis ---");
        boolean algumDisponivel = false;
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("ID: " + livro.getId() + " - Título: \"" + livro.getTitulo() + "\" (Autor: " + livro.getAutor().getNome() + ")");
                algumDisponivel = true;
            }
        }
        if (!algumDisponivel) {
            System.out.println("Nenhum livro disponível no momento.");
        }
        System.out.println("--------------------------\n");
    }

    public Optional<Livro> buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return Optional.of(livro);
            }
        }
        return Optional.empty();
    }

    public boolean realizarEmprestimo(int idLivro, String nomeUsuario) {
        Optional<Livro> livroOpt = buscarLivroPorId(idLivro);

        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            if (livro.isDisponivel()) {
                livro.setDisponivel(false);
                Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
                emprestimos.add(emprestimo);
                System.out.println("\n--------------------------------------------------------------------");
                System.out.println("Livro '" + livro.getTitulo() + "' emprestado para '" + nomeUsuario + "' com sucesso!");
                System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimoFormatada());
                System.out.println("--------------------------------------------------------------------\n");
                return true;
            } else {
                System.out.println("Erro: O livro '" + livro.getTitulo() + "' não está disponível para empréstimo.");
                return false;
            }
        } else {
            System.out.println("Erro: Livro com ID " + idLivro + " não encontrado.");
            return false;
        }
    }

    public void listarTodosOsEmprestimos() { // Método adicional para verificação
        System.out.println("\n--- Todos os Empréstimos Registrados ---");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado até o momento.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
                System.out.println("---");
            }
        }
        System.out.println("--------------------------------------\n");
    }
}