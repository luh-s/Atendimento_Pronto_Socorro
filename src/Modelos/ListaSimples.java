package Modelos;

public class ListaSimples {
    No_SimplesEncadeada inicio;

    public void adicionar(String item) {
        No_SimplesEncadeada novoNo = new No_SimplesEncadeada(item);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No_SimplesEncadeada aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novoNo;
        }
    }

    public void exibir() {
        No_SimplesEncadeada aux = inicio;
        while (aux != null) {
            System.out.println("- " + aux.dado);
            aux = aux.proximo;
        }
    }

    public String listarTexto() {
        if (inicio == null) {
            return "Nenhum registro.";
        }

        String texto = "";
        No_SimplesEncadeada aux = inicio;

        while (aux != null) {
            texto += "- " + aux.dado + "\n";
            aux = aux.proximo;
        }

        return texto;
    }
}