import java.util.Scanner;

public class Alumno extends Persona {
    private String fechaIngreso;
    private String[] listaCursos;

    // constructor
    public Alumno() {
        super();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la fecha de ingreso a la institucion: (dd/mm/aaaa)");
                fechaIngreso = scan.next();
                int retorno = verificarFecha(fechaIngreso);
                if (retorno != 0)
                    throw new FechaException(retorno);
                break;
            } catch (FechaException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
        System.out.println("Ingrese la cantidad de cursos que cursa");
        listaCursos = new String[scan.nextInt()];
        System.out.println("Ingrese la lista de cursos que esta cursando");
        for (int i = 0; i < listaCursos.length; i++) {
            listaCursos[i] = scan.next();
        }
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento, String fechaIngreso, String[] listaCursos) {
        String listaCursosAux = new String();
        for (int i = 0; i < listaCursos.length; i++) {
            listaCursosAux = listaCursosAux + listaCursos[i] + ", ";
        }
        return Persona.mostrarDatos(nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento)
                + "\nCursa desde: " + fechaIngreso
                + "\nCursa " + listaCursosAux;
    }

    public static Alumno modificar(Alumno a) {// modificar una estructura ya cargada
        Alumno alumNew = new Alumno();
        a = alumNew;
        return a;
    }

    public static String[] add(String[] s, int n) {// n = numero de nuevos elementos
        String[] sAux = new String[n];
        for (int i = 0; i < s.length; i++)
            sAux[i] = s[i];
        return sAux;
    }

    // getter & setters
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String[] getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(String[] listaCursos) {
        this.listaCursos = listaCursos;
    }

}