import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Control {

    private List<Results> resultados = new ArrayList<>();

    public void agregar(Results r) {
        resultados.add(r);
    }

    public Integer[] convertir(int[] arr) {
        Integer[] nuevo = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }

    public int[] convertir(Integer[] arr) {
        int[] nuevo = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }

    public void validar(String nombre, int[] base, int[] resultado) {
        for (int i = 0; i < resultado.length - 1; i++) {
            if (resultado[i] > resultado[i + 1]) {
                throw new IllegalStateException(nombre + ": NO está ordenado");
            }
        }
        int[] esperado = Arrays.copyOf(base, base.length);
        Arrays.sort(esperado);
        for (int i = 0; i < esperado.length; i++) {
            if (esperado[i] != resultado[i]) {
                throw new IllegalStateException(nombre + ": NO conserva los elementos");
            }
        }
    }

    public void imprimir() {
        for (Results r : resultados) {
            System.out.println(r);
        }
    }
}