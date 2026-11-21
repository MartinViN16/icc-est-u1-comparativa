import java.util.Locale;

public class Results {

    private String functionName;
    private long duration;
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

    public double getMs() {
        return duration / 1_000_000.0;
    }

    public double getSegundos() {
        return duration / 1_000_000_000.0;
    }

    @Override
    public String toString() {
        String sampleTexto = String.format(Locale.GERMAN, "%,d", sample);
        return "Results [" + functionName + ", duration=" + duration + "ns, "
                + getSegundos() + "s, sample=" + sampleTexto + "]";
    }
}