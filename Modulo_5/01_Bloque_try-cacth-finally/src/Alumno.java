import java.util.Scanner;

public class Alumno extends Persona {
    private String fechaIngreso;
    private String[] listaCursos;

    // constructor
    public Alumno() {
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la fecha de ingreso a la institucion: (dd/mm/aaaa)");
        fechaIngreso = scan.next();
        while (verificarFecha(fechaIngreso) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            fechaIngreso = scan.next();
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

    public static Alumno[] add(Alumno[] a, int n) {// n = numero de nuevos elementos
        Alumno[] aAux = new Alumno[a.length + n];
        for (int i = 0; i < a.length; i++)
            aAux[i] = a[i];
        return aAux;
    }

    public static Alumno[] delete(Alumno[] a, int n) {// n = numero del elemento a eliminar
        Alumno[] aAux = new Alumno[a.length - 1];
        for (int i = 0; i < aAux.length; i++) {
            if (i == n)
                i++;
            aAux[i] = a[i];
        }
        return aAux;
    }

    public static Alumno modificar(Alumno a) {// modificar una estructura ya cargada
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        a.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        a.setApellido(scan.next());
        System.out.println("Ingrese el tipo de documento:");
        String tipoDoc = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDoc = scan.next();
        System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
        a.setFechaNacimiento(scan.next());
        while (verificarFecha(a.getFechaNacimiento()) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            a.setFechaNacimiento(scan.next());
        }
        Documento documento = new Documento(tipoDoc, numDoc);
        a.setDocumento(documento);

        System.out.println("Ingrese la fecha de ingreso:");
        a.setFechaIngreso(scan.next());
        while (verificarFecha(a.getFechaIngreso()) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            a.setFechaIngreso(scan.next());
        }
        System.out.println("Ingrese la cantidad de cursos que esta cuesando:");
        a.listaCursos = add(a.listaCursos, scan.nextInt());
        System.out.println("Ingrese la lista de cursos:");
        for (int i = 0; i < a.listaCursos.length; i++) {
            a.listaCursos[i] = scan.next();
        }
        return a;
    }

    public static String[] add(String[] s, int n) {// n = numero de nuevos elementos
        String[] sAux = new String[n];
        for (int i = 0; i < s.length; i++)
            sAux[i] = s[i];
        return sAux;
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
