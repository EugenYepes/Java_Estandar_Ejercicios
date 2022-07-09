import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private String fechaNacimiento;

    public Persona(){
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
        while (verificarFecha(fechaNacimiento) == false) {// la condicion esta bien
            System.out.println("Vuelva a ingresar la fecha correctamente");
            fechaNacimiento = scan.next();
        }
        documento = new Documento(tipoDocumento, numDocumento);
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento) {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDocumento: "
                + tipoDocumento + ": " + numDocumento
                + "\nFecha de nacimiento: " + fechaNacimiento;
    }

    public static void quienSoy(Persona a) {
        System.out.println("Soy un: " + a);
        System.out.println("y me llamo: " + a.getNombre() + a.getApellido());
    }

    public static Persona[] add(Persona[] p, int n) {// n = numero de nuevos elementos
        Persona[] pAux = new Persona[p.length + n];
        for (int i = 0; i < p.length; i++)
            pAux[i] = p[i];
        return pAux;
    }

    public static Persona[] delete(Persona[] p, int n) {// n = numero del elemento a eliminar
        Persona[] pAux = new Persona[p.length - 1];
        for (int i = 0; i < pAux.length; i++) {
            if (i == n)
                i++;
            pAux[i] = p[i];
        }
        return pAux;
    }

    public static Persona modificar(Persona p) {// modificar el objeto ya cargado
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        p.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        p.setApellido(scan.next());
        System.out.println("Ingrese el tipo de documento:");
        p.documento.setTipoDocumento(scan.next());
        System.out.println("Ingrese el numero de documento:");
        p.documento.setNumDocumento(scan.next());
        System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
        p.setFechaNacimiento(scan.next());
        while (verificarFecha(p.getFechaNacimiento()) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            p.setFechaNacimiento(scan.next());
        }
        return p;
    }

    public static boolean verificarFecha(String fecha) {// se tiene que cumplir el formato dd/mm/aaaa y tienen que ser
        // caracteres numericos
        if (fecha.length() != 10)
            return false;
        for (int i = 0; i < fecha.length(); i++) {
            if (i == 2 || i == 5) {
                if (fecha.charAt(i) != '/') {
                    return false;
                }
            } else {
                if (fecha.charAt(i) < '0' || fecha.charAt(i) > '9') {
                    return false;
                }
            }
        }
        return true;
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