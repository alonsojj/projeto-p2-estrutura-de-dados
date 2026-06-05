public class GestorEmprestimo {

  private NossoHash<String, Fila<Usuario>> map;
  private ListaDupla livros;

  public void solicitarEmprestimo(String isbn, Usuario u) {
    Fila<Usuario> list = map.get(isbn);
    Livro l = livros.buscarPorIsbn(isbn);
    if (list.filaVazia() || l.isDisponivel()) {
      l.setDisponivel(false);
      return;
    }
    list.enfileira(u);
  }

  public void devolverLivro(String isbn) {
    Fila<Usuario> list = map.get(isbn);
    if (list.filaVazia()) {
      Livro l = livros.buscarPorIsbn(isbn);
      l.setDisponivel(true);
      return;
    }
    list.desenfileira();
  }

  public void listarFilaDeEspera(String isbn) {
    Fila<Usuario> list = map.get(isbn);
    System.out.println(list);
  }
}
