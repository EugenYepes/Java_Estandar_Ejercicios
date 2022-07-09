import java.util.Scanner;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private String fechaNacimiento;

    public Persona() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        apellido = scan.next();
        System.out.println("Ingrese el tipo de documento:");
        String tipoDocumento = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDocumento = scan.next();
        System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
        fechaNacimiento = scan.next();
        documento = new Documento(tipoDocumento, numDocumento);
    }

    // metodos
    // public String mostrarDatos(Persona p) {
    // return "Nombre: " + p.getNombre() + "\nApellido: " + p.getApellido() +
    // "\nDocumento: "
    // + p.getDocumento().getTipoDocumento() + ": " +
    // p.getDocumento().getNumDocumento()
    // + "\nFecha de nacimiento: " + p.fechaNacimiento;
    // }

    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento) {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDocumento: "
                + tipoDocumento + ": " + numDocumento
                + "\nFecha de nacimiento: " + fechaNacimiento;
    }
    public static void quienSoy(Persona a){
        System.out.println("Soy un: " + a);
        System.out.println("y me llamo: " + a.getNombre() + a.getApellido());
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

/*
 * @Override
 * public String toString() {
 * return "Alumno [toString()=" + super.toString() + ", cursos=" +
 * Arrays.toString(cursos) + "]";
 * }
 * 
 * @Override
 * public String mostrarTipoPersona() {
 * return getNombre() + " " + getApellido() + " es Alumno";
 * }
 */