
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        //     long nanoTime = System.nanoTime();

        //     long currentTimeMilis = System.currentTimeMillis();
        //     System.out.println("Nano time: " + nanoTime);
        //     System.out.println("Current time: " + currentTimeMilis);
        //     Runnable x = () -> {
        //         System.out.println("Ejecutando tarea 1");
        //         System.out.println("Ejecutando tarea 2");
        //     };
        // List<Integer> list = new ArrayList<>();
        // MetodosOrd mO = new MetodosOrd();
        // mO.burbuja(list);
        // Runnable burbujaOrden = () -> mO.burbuja(list);
        //Callable<T> x
        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> list = g.generate(10000);
        System.out.println(list);

        Results benGenList = b.medir(() -> g.generate(10000), "Generacion de listado", "100");

        System.out.println(benGenList);
    }
}
