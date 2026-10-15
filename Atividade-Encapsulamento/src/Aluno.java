public class Aluno {

    private final String matricula;
    private String nome;
    private String email;

    public Aluno(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void exibirPerfil() {
        System.out.println("Aluno: " + this.nome);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Email: " + this.email);
    }
}
