public class NossoHash<K, V> {
  private Entrada<K, V>[] tabela;
  private int cap;

  @SuppressWarnings("unchecked")
  public NossoHash() {
    tabela = new Entrada[16];
    cap = 16;
  }

  private int hash(K key) {
    return Math.abs(key.hashCode() % cap);
  }

  public void put(K key, V value) {
    int posicao = hash(key);
    Entrada<K, V> entrada = new Entrada<>(key, value);
    entrada.proximo = tabela[posicao];
    tabela[posicao] = entrada;
  }

  public V get(K key) {
    int posicao = hash(key);
    Entrada<K, V> atual = tabela[posicao];
    while (atual != null) {
      if (atual.key.equals(key)) return atual.value;
      atual = atual.proximo;
    }
    return null;
  }

  public boolean containsKey(K key) {
    int posicao = hash(key);
    Entrada<K, V> atual = tabela[posicao];
    while (atual != null) {
      if (atual.key.equals(key)) return true;
      atual = atual.proximo;
    }
    return false;
  }

  public boolean containsValue(V value) {
    for (int i = 0; i < tabela.length; i++) {
      Entrada<K, V> atual = tabela[i];
      while (atual != null) {
        if (atual.value.equals(value)) return true;
        atual = atual.proximo;
      }
    }
    return false;
  }

  public void exibeMap() {
    for (int i = 0; i < tabela.length; i++) {
      System.out.println("Posicao " + i);
      Entrada<K, V> atual = tabela[i];
      while (atual != null) {
        System.out.println("key:" + atual.key + " value: " + atual.value);
        atual = atual.proximo;
      }
    }
  }
}
