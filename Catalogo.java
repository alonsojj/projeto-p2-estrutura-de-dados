public class Catalogo {

  private NossoHash<String, Livro> catalog;

  public void cadastra(Livro livro) {
    catalog.put(livro.getIsbn(), livro);
  }

  public Livro buscar(String isbn) {
    return catalog.get(isbn);
  }

  public boolean existe(String isbn) {
    return catalog.containsKey(isbn);
  }

  public void exibirCatalogo() {
    catalog.exibeMap();
  }
}
