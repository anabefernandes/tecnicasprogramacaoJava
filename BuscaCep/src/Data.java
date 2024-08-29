import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("datetime")
    private String hora;
    @SerializedName("local")
    private String local;

    public Data(String hora, String local) {
        this.hora = hora;
        this.local = local;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Data{" +
                "hora='" + hora + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
