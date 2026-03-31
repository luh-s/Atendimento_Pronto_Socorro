package App;
import Modelos.*;
import Telas.TelaLogin;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayUnidades unidades = new ArrayUnidades();
        new TelaLogin(unidades);
    }
}
