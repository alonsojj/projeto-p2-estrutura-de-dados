public class TesteListaDupla {

  public static void main(String[] args) {
    Livro l0 = new Livro("0", "livro0", "autor", 2000);
    Livro l1 = new Livro("1", "livro1", "autor", 2000);
    Livro l2 = new Livro("2", "livro2", "autor", 2000);
    Livro l3 = new Livro("3", "livro3", "autor", 2000);
    ListaDupla list = new ListaDupla();
    System.out.println("Inserindo Livros no inicio em ordem descrecente");
    list.insereInicio(l0);
    list.insereInicio(l1);
    list.insereInicio(l2);
    list.insereInicio(l3);
    System.out.println("\n\nListando do Inicio ao Fim");
    list.listarDoInicio();
    System.out.println("\n\nListando do Fim ao Inicio");
    list.listarDoFim();

    System.out.println("\n\nInserindo livro 4 no final - Listando do Inicio");
    Livro l4 = new Livro("4", "livro4", "autor", 2000);
    list.insereFim(l4);
    list.listarDoInicio();

    System.out.println("\n\nRemovendo livro no final - Listando do Inicio");
    System.out.println("Removendo: " + list.removeUltimo());
    list.listarDoInicio();

    System.out.println("\n\nRemovendo livro no inicio - Listando do Inicio");
    System.out.println("Removendo: " + list.removePrimeiro());
    list.listarDoInicio();

    System.out.println("tamanho :" + list.tamanho());

    System.out.println("\n\nBuscando Livro 1");
    Livro find = list.buscarPorIsbn("1");
    System.out.println("Livro encontrado: " + find);
  }
}
