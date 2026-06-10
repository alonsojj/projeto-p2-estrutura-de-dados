public class GestorEmprestimos {

  private NossoHash<String, Fila<Usuario>> map;
  private Catalogo catalog;// Precisa alguma forma de acessar/alterar a disponivilidade do livro, usei o
                           // catalogo
                           // pois ele tem O(1) para encontrar livros

  public GestorEmprestimos() {
  }

  public GestorEmprestimos(Catalogo catalog) {
    this.catalog = catalog;
    this.map = new NossoHash<>();
  }

  public void solicitarEmprestimo(String isbn, Usuario u) {
    if (!map.containsKey(isbn)) {
      map.put(isbn, new Fila<>());
    }
    Fila<Usuario> list = map.get(isbn);
    Livro l = catalog.buscar(isbn);
    if (list.filaVazia() || l.isDisponivel()) {
      l.setDisponivel(false);
      return;
    }
    list.enfileira(u);
  }

  public void devolverLivro(String isbn) {
    Fila<Usuario> list = map.get(isbn);
    if (list.filaVazia()) {
      Livro l = catalog.buscar(isbn);
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
