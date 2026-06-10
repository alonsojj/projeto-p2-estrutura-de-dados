public class ListaDupla {
  private NoDuplo primeiro;
  private NoDuplo ultimo;

  private boolean estaVazia() {
    return primeiro == null;
  }

  public void insereInicio(Livro livro) {
    NoDuplo nv = new NoDuplo(livro);
    if (estaVazia()) {
      ultimo = nv;
    } else {
      nv.setProximo(primeiro);
      primeiro.setAnterior(nv);
    }
    primeiro = nv;
  }

  public Livro removePrimeiro() {
    if (estaVazia()) return null;
    Livro aux = primeiro.getInfo();
    primeiro = primeiro.getProximo();
    if (primeiro == null) {
      ultimo = null;
    } else {
      primeiro.setAnterior(null);
    }
    return aux;
  }

  public void insereFim(Livro livro) {
    NoDuplo nv = new NoDuplo(livro);
    if (estaVazia()) {
      primeiro = nv;
    } else {
      ultimo.setProximo(nv);
      nv.setAnterior(ultimo);
    }
    ultimo = nv;
  }

  public Livro removeUltimo() {
    if (estaVazia()) return null;
    Livro aux = ultimo.getInfo();
    ultimo = ultimo.getAnterior();
    if (ultimo == null) {
      primeiro = null;
    } else {
      ultimo.setProximo(null);
    }
    return aux;
  }

  public Livro buscarPorIsbn(String isbn) {
    NoDuplo atual = primeiro;
    while (atual != null) {
      if (atual.getInfo().getIsbn().equals(isbn)) {
        return atual.getInfo();
      }
      atual = atual.getProximo();
    }
    return null;
  }

  public void listarDoInicio() {
    NoDuplo atual = primeiro;
    while (atual != null) {
      System.out.println(atual.getInfo());
      atual = atual.getProximo();
    }
  }

  public void listarDoFim() {
    NoDuplo atual = ultimo;
    while (atual != null) {
      System.out.println(atual.getInfo());
      atual = atual.getAnterior();
    }
  }

  public int tamanho() {
    NoDuplo atual = primeiro;
    int tamanho = 0;
    while (atual != null) {
      tamanho++;
      atual = atual.getProximo();
    }
    return tamanho;
  }
}
