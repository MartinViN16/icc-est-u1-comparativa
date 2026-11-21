import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Algoritmos a = new Algoritmos();
        Control control = new Control();

        // ---- FUERA del cronómetro: muestras base ----
        int[] list1 = g.generate(10000);
        int[] list2 = g.generate(50000);
        int[] list3 = g.generate(100000);

        // ---- FUERA del cronómetro: un clon independiente por variante ----
        int[] l1v1 = Arrays.copyOf(list1, list1.length);
        int[] l1v2 = Arrays.copyOf(list1, list1.length);
        int[] l1v3 = Arrays.copyOf(list1, list1.length);
        Integer[] l1v4 = control.convertir(list1);
        int[] l2v1 = Arrays.copyOf(list2, list2.length);
        int[] l2v2 = Arrays.copyOf(list2, list2.length);
        int[] l2v3 = Arrays.copyOf(list2, list2.length);
        Integer[] l2v4 = control.convertir(list2);
        int[] l3v1 = Arrays.copyOf(list3, list3.length);
        int[] l3v2 = Arrays.copyOf(list3, list3.length);
        int[] l3v3 = Arrays.copyOf(list3, list3.length);
        Integer[] l3v4 = control.convertir(list3);

        Results resultadosM1S1 = Benchmark.medir(
            () -> a.sortBubble(l1v1), "V1 Burbuja", 10000);
        control.validar("V1 Burbuja", list1, l1v1);
        control.agregar(resultadosM1S1);

        Results resultadosM2S1 = Benchmark.medir(
            () -> a.sortMerge(l1v2), "V2 Merge Sort", 10000);
        control.validar("V2 Merge Sort", list1, l1v2);
        control.agregar(resultadosM2S1);

        Results resultadosM3S1 = Benchmark.medir(
            () -> a.sortArrays(l1v3), "V3 Arrays.sort(int[])", 10000);
        control.validar("V3 Arrays.sort(int[])", list1, l1v3);
        control.agregar(resultadosM3S1);

        Results resultadosM4S1 = Benchmark.medir(
            () -> a.sortArraysComparator(l1v4), "V4 Arrays.sort(Integer[], Comparator)", 10000);
        control.validar("V4 Arrays.sort(Integer[], Comparator)", list1, control.convertir(l1v4));
        control.agregar(resultadosM4S1);

        Results resultadosM1S2 = Benchmark.medir(
            () -> a.sortBubble(l2v1), "V1 Burbuja", 50000);
        control.validar("V1 Burbuja", list2, l2v1);
        control.agregar(resultadosM1S2);

        Results resultadosM2S2 = Benchmark.medir(
            () -> a.sortMerge(l2v2), "V2 Merge Sort", 50000);
        control.validar("V2 Merge Sort", list2, l2v2);
        control.agregar(resultadosM2S2);

        Results resultadosM3S2 = Benchmark.medir(
            () -> a.sortArrays(l2v3), "V3 Arrays.sort(int[])", 50000);
        control.validar("V3 Arrays.sort(int[])", list2, l2v3);
        control.agregar(resultadosM3S2);

        Results resultadosM4S2 = Benchmark.medir(
            () -> a.sortArraysComparator(l2v4), "V4 Arrays.sort(Integer[], Comparator)", 50000);
        control.validar("V4 Arrays.sort(Integer[], Comparator)", list2, control.convertir(l2v4));
        control.agregar(resultadosM4S2);

        // ================= Tamaño 100000 =================
        Results resultadosM1S3 = Benchmark.medir(
            () -> a.sortBubble(l3v1), "V1 Burbuja", 100000);
        control.validar("V1 Burbuja", list3, l3v1);
        control.agregar(resultadosM1S3);

        Results resultadosM2S3 = Benchmark.medir(
            () -> a.sortMerge(l3v2), "V2 Merge Sort", 100000);
        control.validar("V2 Merge Sort", list3, l3v2);
        control.agregar(resultadosM2S3);

        Results resultadosM3S3 = Benchmark.medir(
            () -> a.sortArrays(l3v3), "V3 Arrays.sort(int[])", 100000);
        control.validar("V3 Arrays.sort(int[])", list3, l3v3);
        control.agregar(resultadosM3S3);

        Results resultadosM4S3 = Benchmark.medir(
            () -> a.sortArraysComparator(l3v4), "V4 Arrays.sort(Integer[], Comparator)", 100000);
        control.validar("V4 Arrays.sort(Integer[], Comparator)", list3, control.convertir(l3v4));
        control.agregar(resultadosM4S3);

        // Imprime la lista completa al finalizar las 12 mediciones
        control.imprimir();
    }
}