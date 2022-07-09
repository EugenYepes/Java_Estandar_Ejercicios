import java.util.Scanner;

public class Director extends Persona {
    private String fechaCargo;
    private String carrera;
    private int sueldo;

    // constructor
    public Director() {
        super();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la fecha de ingreso al cargo: (dd/mm/aaaa)");
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
        System.out.println("Ingrese la carrera de la cual es director");
        carrera = scan.next();
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento, String fechaCargo, int sueldo, String carrera) {

        return Persona.mostrarDatos(nombre, apellido, tipoDocumento, numDocumento, fechaNacimiento)
                + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo
                + "\nEs director de: " + carrera;
    }

    public static Director[] add(Director[] d, int n) {// n = numero de nuevos elementos
        Director[] dAux = new Director[d.length + n];
        for (int i = 0; i < d.length; i++)
            dAux[i] = d[i];
        return dAux;
    }

    public static Director[] delete(Director[] d, int n) {// n = numero del elemento a eliminar
        Director[] dAux = new Director[d.length - 1];
        for (int i = 0; i < dAux.length; i++) {
            if (i == n)
                i++;
            dAux[i] = d[i];
        }
        return dAux;
    }

    public static Director modificar(Director d) {// modificar una estructura ya cargada
        Director dirNew = new Director();
        d = dirNew;
        return d;
    }

    // getters & setters
    public String getFechaCargo() {
        return fechaCargo;
    }

    public void setFechaCargo(String fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
