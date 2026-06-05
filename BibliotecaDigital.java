import java.util.Scanner;

public class BibliotecaDigital {
  private static final String TEXTO =
      """
                          BIBLIOTECA DIGITAL
            =================================================
            | 1. Cadastrar Livro                            |
            | 2. Buscar Livro por ISBN                      |
            | 3. Listar Acervo (Início ao Fim)              |
            | 4. Listar Acervo (Fim ao Início)              |
            | 5. Solicitar Empréstimo                       |
            | 6. Devolver Livro                             |
            | 7. Ver Fila de Espera de um Livro             |
            | 0. Sair                                       |
            =================================================
      """;
  private static Catalogo catalogo = new Catalogo();
  private static ListaDupla acervo = new ListaDupla();
  private static GestorEmprestimos gestor;

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int input = -1;
    gestor =
        new GestorEmprestimos(); // N informado sobre isso no PDF mas sem isso as listas ficariam
    // desincronizada caso algum livro fosse adicionada
    do {
      System.out.println(TEXTO);
      input = scn.nextInt();
      switch (input) {
        case 1:
          System.out.println("\n--- CADASTRAR LIVRO ---");
          System.out.print("ISBN: ");
          String isbn = scn.nextLine();
          System.out.print("Título: ");
          String titulo = scn.nextLine();
          System.out.print("Autor: ");
          String autor = scn.nextLine();
          System.out.print("Ano de Publicação: ");
          int ano = Integer.parseInt(scn.nextLine());

          Livro novoLivro = new Livro(isbn, titulo, autor, ano);

          acervo.insereFim(novoLivro);
          catalogo.cadastra(novoLivro);
          System.out.println("Livro cadastrado com sucesso!\n");
          break;
        case 2:
          System.out.println("\n--- BUSCAR LIVRO POR ISBN ---");
          System.out.print("Digite o ISBN: ");
          String search = scn.nextLine();
          Livro livro = catalogo.buscar(search);
          if (livro != null) {
            System.out.println("Livro Encontrado: " + livro);
          } else {
            System.out.println("Livro não encontrado no catálogo.");
          }
          System.out.println();
          break;
        case 3:
          System.out.println();
          acervo.listarDoInicio();
          System.out.println();
          break;
        case 4:
          System.out.println();
          acervo.listarDoFim();
          System.out.println();
          break;
        case 5:
          System.out.println("\n--- SOLICITAR EMPRÉSTIMO ---");
          System.out.print("Matrícula do Usuário: ");
          int matricula = Integer.parseInt(scn.nextLine());
          System.out.print("Nome do Usuário: ");
          String nome = scn.nextLine();
          System.out.print("Email do Usuário: ");
          String email = scn.nextLine();
          System.out.print("ISBN do Livro Desejado: ");
          String isbnSolicitado = scn.nextLine();

          Usuario usuario = new Usuario(matricula, nome, email);
          gestor.solicitarEmprestimo(isbnSolicitado, usuario);
          System.out.println();
          break;
        case 6:
          System.out.println("\n--- DEVOLVER LIVRO ---");
          System.out.print("Digite o ISBN do livro a ser devolvido: ");
          String isbnDevolucao = scn.nextLine();

          gestor.devolverLivro(isbnDevolucao);
          System.out.println();
          break;
        case 7:
          System.out.println("\n--- FILA DE ESPERA ---");
          System.out.print("Digite o ISBN do livro: ");
          String isbnFila = scn.nextLine();

          gestor.listarFilaDeEspera(isbnFila);
          System.out.println();
          break;
        case 0:
          System.out.println("\nSaindo do sistema... Até logo!");
          break;
        default:
          System.out.println("\nOpção inválida! Tente novamente.\n");
          break;
      }

    } while (input != 0);
    scn.close();
  }
}
