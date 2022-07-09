import java.util.Scanner;

public class Administrativo extends Persona {
    private String fechaCargo;
    private int sueldo;

    // constructor
    public Administrativo() {
        super();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la fecha de ingreso al cargo:");
                fechaCargo = scan.next();
                int retorno = verificarFecha(fechaCargo);
                if (retorno != 0)
                    throw new FechaException(retorno);
                break;
            } catch (FechaException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento, String fechaCargo, int sueldo) {

        return Persona.mostrarDatos(nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento)
                + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo;
    }

    public static Administrativo[] add(Administrativo[] a, int n) {// n = numero de nuevos elementos
        Administrativo[] aAux = new Administrativo[a.length + n];
        for (int i = 0; i < a.length; i++)
            aAux[i] = a[i];
        return aAux;
    }

    public static Administrativo[] delete(Administrativo[] a, int n) {// n = numero del elemento a eliminar
        Administrativo[] aAux = new Administrativo[a.length - 1];
        for (int i = 0; i < aAux.length; i++) {
            if (i == n)
                i++;
            aAux[i] = a[i];
        }
        return aAux;
    }

    public static Administrativo modificar(Administrativo a) {// modificar una estructura ya
                                                                                    // cargada
        Administrativo admNew = new Administrativo();
        a = admNew;
        return a;
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
}