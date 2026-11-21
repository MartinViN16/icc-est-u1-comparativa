public class Benchmark {

    public static Results medir(Runnable accion, String nombre, int sample) {
        Throwable error = null;

        long inicio = System.nanoTime();
        try {
            accion.run();
        } catch (Throwable t) {
            error = t;
        }
        long fin = System.nanoTime();

        if (error != null) {
            throw new RuntimeException("Falló " + nombre + " con sample " + sample, error);
        }
        return new Results(nombre, fin - inicio, sample);
    }
}