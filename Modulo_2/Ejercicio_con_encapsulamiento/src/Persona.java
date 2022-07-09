import java.time.Clock;
import java.util.Random;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String tipoDocumento, String numeroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        documento = new Documento(tipoDocumento, numeroDocumento);
        // edad generada automaticamente
        Clock horaInMs = Clock.systemDefaultZone();
        long ms = horaInMs.millis();
        Random rand = new Random(ms);
        edad = rand.nextInt(90);
    }

    public Persona(String nombre, String apellido, String tipoDocumento, String numeroDocumento, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        documento = new Documento(tipoDocumento, numeroDocumento);
    }

    public void randomEdad(){
        int edad;
        Clock horaInMs = Clock.systemDefaultZone();
        long ms = horaInMs.millis();
        Random rand = new Random(ms);
        edad = rand.nextInt(90);
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
