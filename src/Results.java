public class Results {

    private String functionName;
    private long duration;   // nanosegundos
    private int sample;

    public Results(String functionName, long duration, int sample) {
        this.functionName = functionName;
        this.duration = duration;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public long getDuration() {
        return duration;
    }

    public int getSample() {
        return sample;
    }

    // Convierte nanosegundos a milisegundos
    public double getMs() {
        return duration / 1_000_000.0;
    }

    @Override
    public String toString() {
        return functionName + " | sample = " + sample + " | " + getMs() + " ms";
    }
}