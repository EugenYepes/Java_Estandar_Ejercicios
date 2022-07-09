import java.time.Clock;
import java.util.Random;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    public static int contador = 0;
    private int id = 0;
    private int edad;

    // constructores
    public Persona() {
        contador++;
        id = contador;
    }

    public Persona(String nombre, String apellido, String tipoDocumento, String numeroDocumento) {
        contador++;
        id = contador;
        this.nombre = nombre;
        this.apellido = apellido;
        documento = new Documento(tipoDocumento, numeroDocumento);
        // edad generada automaticamente
        Clock horaInMs = Clock.systemDefaultZone();
        long ms = horaInMs.millis();
        Random rand = new Random(ms);
        edad = rand.nextInt(90);
    }

    // metodos
    public void randomEdad() {
        int edad;
        Clock horaInMs = Clock.systemDefaultZone();
        long ms = horaInMs.millis();
        Random rand = new Random(ms);
        edad = rand.nextInt(90);
        this.edad = edad;
    }

    public static void mostrarDatos(Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            System.out.println("\nPersona ID: " + personas[i].id); // forma de guardar el id que declare como static
            System.out.println("Nombre: " + personas[i].getNombre());
            System.out.println("Apellido: " + personas[i].getApellido());
            System.out.println("Tipo de documento: " + personas[i].getDocumento().getTipo());
            System.out.println("Numero de documento: " + personas[i].getDocumento().getNumero());
            System.out.print("Edad (inventada): " + personas[i].getEdad());
            if (personas[i].getEdad() >= 18) {
                System.out.println(" y es mayor de edad");
            } else {
                System.out.println(" y es menor de edad");
            }
        }
        System.out.println("\nLa cantidad de personas ingresadas es: " + personas.length);
    }

    // getters & setters
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

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Persona.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}