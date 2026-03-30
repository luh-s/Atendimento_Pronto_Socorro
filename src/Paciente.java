public class Paciente {
    private int id,idade;
    private String nome,cpf,prioridade,sintomas,statusAtendimento;

    public Paciente(int id, int idade, String nome, String cpf, String prioridade, String sintomas, String statusAtendimento) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.sintomas = sintomas;
        this.statusAtendimento = statusAtendimento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    public String getSintomas() {
        return sintomas;
    }
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
    public String getStatusAtendimento() {
        return statusAtendimento;
    }
    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }
    public void cadastrar(ListaPacienteTemp lista){
        lista.inserir(this);
    }
    public void atualizarDados(){
        
    }
    public void exibirDados(){
        System.out.println("-----------------------------\nId: "+getId()+"\nPrioridade: "+getPrioridade()+"\nPaciente: "+getNome()+"\nIdade: "+getIdade()+"\nCpf: "+getCpf()+
        "\nSintomas: "+getSintomas()+"\nStatus de atendimento: "+getStatusAtendimento()+"\n-----------------------------");
    }
}
