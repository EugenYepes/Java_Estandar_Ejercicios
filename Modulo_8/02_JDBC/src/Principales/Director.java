package Principales;

import java.util.Scanner;

import excepciones.FechaException;

public class Director extends Persona {
    private String fechaCargo;
    private String carrera;
    private int sueldo;
    Scanner scan = new Scanner(System.in);

    // constructor
    public Director() {
        super();
        fechaCargo = setFechaCargo();
        System.out.println("Ingrese la carrera de la cual es director");
        carrera = scan.next();
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
    }

    public Director(String nombre, String apellido, Documento documento, String fechaNacimiento, String fechaCargo,
            String carrera, int sueldo) {
        super(nombre, apellido, documento, fechaNacimiento);
        this.fechaCargo = fechaCargo;
        this.carrera = carrera;
        this.sueldo = sueldo;
    }

    public Director(Documento doc) {
        super(doc);
        fechaCargo = setFechaCargo();
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

    public String setFechaCargo() {
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
        return fechaCargo;
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

    public void scanClose() {
        scan.close();
    }
}