
import java.util.Arrays;
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
        Algoritmos a = new Algoritmos();

        int[] list1 = g.generate(10000);
        int[] list2 = g.generate(50000);
        int[] list3 = g.generate(100000);

        // List<Integer> list2c1 = list2.clone();
        List<Integer> list2c1 = Arrays.copyOf(list2, list2.size());

        
        Results resultadosM1S1 = Benchmark.medir(
            () ->  a.sortBubble(list1), "Burbuja", "10000");

        Results resultadosM1S2 = Benchmark.medir(
            () ->  a.sortBubble(list2), "Burbuja", "50000");

        Results resultadosM1S3 = Benchmark.medir(
            () ->  a.sortBubble(list3), "Burbuja", "100000");

        Results resultadosM2S1 = Benchmark.medir(
            () ->  a.sortMerge(list1), "Merge", "10000");

        Results resultadosM2S2 = Benchmark.medir(
            () ->  a.sortMerge(list2), "Merge", "50000");

        Results resultadosM2S3 = Benchmark.medir(
            () ->  a.sortMerge(list3), "Merge", "100000");

        Results resultadosM3S1 = Benchmark.medir(
            () ->  a.collectionSort(list1), "Colección", "10000");

        Results resultadosM3S2 = Benchmark.medir(
            () ->  a.collectionSort(list2), "Colección", "50000");

        Results resultadosM3S3 = Benchmark.medir(
            () ->  a.collectionSort(list3), "Colección", "100000");
    }
}
