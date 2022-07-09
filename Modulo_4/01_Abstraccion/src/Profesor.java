import java.util.Scanner;

public class Profesor extends Persona {
    private String fechaCargo;
    private int sueldo;
    private String[] listaCursos;

    // constructor
    public Profesor() {
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la fecha de ingreso al cargo:");
        fechaCargo = scan.next();
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
        System.out.println("Ingrese la cantidad de cursos a los que esta asignado");
        listaCursos = new String[scan.nextInt()];
        System.out.println("Ingrese la lista de cursos a los que esta asignado");
        for (int i = 0; i < listaCursos.length; i++) {
            listaCursos[i] = scan.next();
        }
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento, String fechaCargo, int sueldo, String[] listaCursos) {
        String listaCursosAux = new String();
        for (int i = 0; i < listaCursos.length; i++) {
            listaCursosAux = listaCursosAux + listaCursos[i] + ", ";
        }
        return Persona.mostrarDatos(nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento)
                + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo
                + "\nTiene a su cargo los siguientes cursos: " + listaCursosAux;
    }

    // getters & setters
    public String getFechaCargo() {
        return fechaCargo;
    }

    public void setFechaCargo(String fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String[] getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(String[] listaCursos) {
        this.listaCursos = listaCursos;
    }
}
