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

    public static Profesor[] add(Profesor[] p, int n) {// n = numero de nuevos elementos
        Profesor[] pAux = new Profesor[p.length + n];
        for (int i = 0; i < p.length; i++)
            pAux[i] = p[i];
        return pAux;
    }

    public static Profesor[] delete(Profesor[] p, int n) {// n = numero del elemento a eliminar
        Profesor[] pAux = new Profesor[p.length - 1];
        for (int i = 0; i < pAux.length; i++) {
            if (i == n)
                i++;
            pAux[i] = p[i];
        }
        return pAux;
    }

    public static Profesor modificar(Profesor p) {// modificar el objeto ya cargado
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        p.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        p.setApellido(scan.next());
        System.out.println("Ingrese el tipo de documento:");
        String tipoDoc = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDoc = scan.next();
        System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
        p.setFechaNacimiento(scan.next());
        Documento documento = new Documento(tipoDoc, numDoc);
        p.setDocumento(documento);

        System.out.println("Ingrese la fecha de ingreso al cargo:");
        p.setFechaCargo(scan.next());
        System.out.println("Ingrese el sueldo:");
        p.setSueldo(scan.nextInt());
        System.out.println("Ingrese la cantidad de cursos a los que esta asignado:");
        p.listaCursos = add(p.listaCursos, scan.nextInt());
        System.out.println("Ingrese la lista de cursos a los que esta asignado:");
        for (int i = 0; i < p.listaCursos.length; i++) {
            p.listaCursos[i] = scan.next();
        }
        return p;
    }

    public static String[] add(String[] s, int n) {// n = numero de nuevos elementos
        String[] sAux = new String[n];
        for (int i = 0; i < s.length; i++)
            sAux[i] = s[i];
        return sAux;
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