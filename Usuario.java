public class Usuario {

  private int matricula;
  private String nome;
  private String email;

  public int getMatricula() {
    return matricula;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(matricula).append(" | ").append(nome).append(" - ").append(email);
    return sb.toString();
  }

  public boolean equals(Usuario comp) {
    return comp.getMatricula() == this.matricula;
  }
}
