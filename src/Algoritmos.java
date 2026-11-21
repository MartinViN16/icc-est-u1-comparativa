import java.util.Arrays;

public class Algoritmos {

    public int[] sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                    swap = true;
                }
            }
            if (!swap) {
                return arr;
            }
        }
        return arr;
    }

    public int[] sortMerge(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] aux = new int[arr.length];   // cuenta dentro del cronómetro
        mergeSort(arr, aux, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int[] aux, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        int medio = inicio + (fin - inicio) / 2;
        mergeSort(arr, aux, inicio, medio);
        mergeSort(arr, aux, medio + 1, fin);
        merge(arr, aux, inicio, medio, fin);
    }

    private void merge(int[] arr, int[] aux, int inicio, int medio, int fin) {
        for (int k = inicio; k <= fin; k++) {
            aux[k] = arr[k];
        }
        int i = inicio;
        int j = medio + 1;
        for (int k = inicio; k <= fin; k++) {
            if (i > medio) {
                arr[k] = aux[j++];
            } else if (j > fin) {
                arr[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }

    public int[] sortArrays(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public Integer[] sortArraysComparator(Integer[] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a, b));
        return arr;
    }
}