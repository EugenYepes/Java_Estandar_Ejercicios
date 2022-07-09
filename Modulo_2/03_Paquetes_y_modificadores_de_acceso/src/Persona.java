import java.time.Clock;
import java.util.Random;

public class Persona {
    String nombre;
    String apellido;
    // private int edad;
    Documento doc;
    Clock horaInMs = Clock.systemDefaultZone();// obtener una semilla para generar el numero random
    long ms = horaInMs.millis();
    Random rand = new Random(ms);
    private int edad = rand.nextInt(90);

    public Persona(String miNombre, String miApellido, String miTipoDocumento, String miNumeroDocumento) {
        doc = new Documento(miTipoDocumento, miNumeroDocumento);
        nombre = miNombre;
        apellido = miApellido;
    }


    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public String mayorEdad() {
        if (edad >= 18)
            return "Es mayor de edad";
        else
            return "Es menor de edad";
    }
}
