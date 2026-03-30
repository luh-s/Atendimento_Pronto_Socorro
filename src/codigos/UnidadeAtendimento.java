package codigos;
public class UnidadeAtendimento {
    private String nome,senha; //Preciso dessas duas variaveis para relizar a separação e cadastro das unidades//

    public UnidadeAtendimento(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
