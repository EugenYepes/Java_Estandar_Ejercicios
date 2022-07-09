import java.util.Scanner;

public class Director extends Persona {
    private String fechaCargo;
    private String carrera;
    private int sueldo;

    // constructor
    public Director() {
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la fecha de ingreso al cargo: (dd/mm/aaaa)");
        fechaCargo = scan.next();
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
