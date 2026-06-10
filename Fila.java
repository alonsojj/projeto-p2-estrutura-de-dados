public class Fila<T> {
  private No<T> primeiro;
  private No<T> ultimo;

  public boolean filaVazia() {
    return primeiro == null;
  }

  public void enfileira(T info) {
    No<T> nv = new No<>(info);
    if (filaVazia()) {
      primeiro = nv;
    } else {
      ultimo.setProximo(nv);
    }
    ultimo = nv;
  }

  public T desenfileira() {
    if (filaVazia())
      throw new FilaVaziaException("Fila estava vazia");
    T aux = primeiro.getInfo();
    primeiro = primeiro.getProximo();
    if (primeiro == null) {
      ultimo = null;
    }
    return aux;
  }

  public T primeiro() {
    return primeiro.getInfo();
  }

  public int tamanho() {
    int count = 0;
    No<T> atual = primeiro;
    while (atual != null) {
      count++;
      atual = atual.getProximo();
    }
    return count;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    No<T> atual = primeiro;
    while (atual != null) {
      sb.append(atual).append("->");
      atual = atual.getProximo();
    }
    sb.append("\\");
    return sb.toString();
  }
}
