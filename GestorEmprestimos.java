public class GestorEmprestimos {

  private NossoHash<String, Fila<Usuario>> map;
  private Catalogo catalog;// Precisa alguma forma de acessar/alterar a disponivilidade do livro, usei o
                           // catalogo
                           // pois ele tem O(1) para encontrar livros

  public GestorEmprestimos(Catalogo catalog) {
    this.catalog = catalog;
    this.map = new NossoHash<>();
  }

  private void emprestaProxAux(Fila<Usuario> list, Livro l) {// metodo para auxiliar o emprestimo; DRY
    if (l.isDisponivel() && !list.filaVazia()) {
      Usuario proximo = list.desenfileira();
      l.setDisponivel(false);
      System.out.println("Próximo usuário atendido: " + proximo);
    }
  }

  public void solicitarEmprestimo(String isbn, Usuario u) {
    if (!map.containsKey(isbn)) {
      map.put(isbn, new Fila<>());
    }
    Fila<Usuario> list = map.get(isbn);
    Livro l = catalog.buscar(isbn);
    list.enfileira(u);
    emprestaProxAux(list, l);
  }

  public void devolverLivro(String isbn) {
    Fila<Usuario> list = map.get(isbn);
    Livro l = catalog.buscar(isbn);
    if (list == null || list.filaVazia()) {
      l.setDisponivel(true);
      return;
    }
    emprestaProxAux(list, l);

  }

  public void listarFilaDeEspera(String isbn) {
    Fila<Usuario> list = map.get(isbn);
    if (list == null || list.filaVazia()) {
      System.out.println("Nenhuma fila de espera para este livro.");
      return;
    }
    System.out.println(list);
  }
}
