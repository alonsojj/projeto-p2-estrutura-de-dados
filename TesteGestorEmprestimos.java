public class TesteGestorEmprestimos {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Livro livro = new Livro("01", "Harry Potter", "JK Rowling", 2010);
        catalogo.cadastra(livro);

        GestorEmprestimos gestor = new GestorEmprestimos(catalogo);

        Usuario usuario1 = new Usuario(1001, "Aline", "aline@example.com");
        Usuario usuario2 = new Usuario(1002, "Gabriel", "gabriel@example.com");

        System.out.println("1. Emprestimo do livro disponivel para Aline");
        gestor.solicitarEmprestimo("01", usuario1);
        System.out.println("Livro disponivel " + catalogo.buscar("01").isDisponivel());
        gestor.listarFilaDeEspera("01");

        System.out.println("\n2. Segunda solicitacao do mesmo livro para Gabriel (deve entrar na fila)");
        gestor.solicitarEmprestimo("01", usuario2);
        System.out.println("Livro disponivel " + catalogo.buscar("01").isDisponivel());
        gestor.listarFilaDeEspera("01");

        System.out.println("\n3. Devolucao do livro (deve atender Gabriel automaticamente)");
        gestor.devolverLivro("01");
        System.out.println("Livro disponivel " + catalogo.buscar("01").isDisponivel());
        gestor.listarFilaDeEspera("01");

        System.out.println("\n4. Segunda devolucao com fila vazia (livro deve ficar disponivel)");
        gestor.devolverLivro("01");
        System.out.println("Livro disponivel " + catalogo.buscar("01").isDisponivel());
        gestor.listarFilaDeEspera("01");
    }
}