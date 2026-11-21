public class Benchmark {

    // Recibe la operación como Runnable (lambda sin parámetros ni retorno)
    public static Results medir(Runnable accion, String nombre, int sample) {
        Throwable error = null;

        long inicio = System.nanoTime();
        try {
            accion.run();
        } catch (Throwable t) {
            error = t;
        }
        long fin = System.nanoTime();

        // Si falló, NO se devuelve ningún tiempo: se lanza el error con su causa original
        if (error != null) {
            throw new RuntimeException("Falló " + nombre + " con sample " + sample, error);
        }
        return new Results(nombre, fin - inicio, sample);
    }
}