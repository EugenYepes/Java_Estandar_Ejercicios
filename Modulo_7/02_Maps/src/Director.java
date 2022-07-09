import java.util.Scanner;

import excepciones.FechaException;

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
    @Override
    public String toString() {
        return super.toString() + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo
                + "\nEs director de: " + carrera;
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