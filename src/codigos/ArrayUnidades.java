package codigos;
import java.util.ArrayList;

public class ArrayUnidades {
    ArrayList<UnidadeAtendimento> unidades = new ArrayList<>();

    public void cadastro(UnidadeAtendimento unidade){
        unidades.add(unidade);
    }
    public boolean verificar(String nome,String senha){
        for (UnidadeAtendimento unidade: unidades) {
            if (unidade.getNome().equals(nome) && unidade.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
