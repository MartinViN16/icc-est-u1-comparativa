
public class Benchmark {

    public static Results medir(Runnable accion, String nombre, String sample) {
        //tiempo actual
        long tiempoActual = System.nanoTime();
        //accion
        accion.run();
        //tiempo final
        long tiempoFinal = System.nanoTime();
        //retornar el tiempo duracion

        Results results = new Results(nombre, (tiempoFinal - tiempoActual), sample);

        return results;
    }
}
