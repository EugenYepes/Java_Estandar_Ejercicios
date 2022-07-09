package Principales;

import java.util.Scanner;

import excepciones.FechaException;

public class Administrativo extends Persona {
    private String fechaCargo;
    private int sueldo;
    Scanner scan = new Scanner(System.in);

    // constructor
    public Administrativo() {
        super();
        fechaCargo = setFechaCargo();
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
    }

    public Administrativo(String nombre, String apellido, Documento documento, String fechaNacimiento,
            String fechaCargo, int sueldo) {
        super(nombre, apellido, documento, fechaNacimiento);
        this.fechaCargo = fechaCargo;
        this.sueldo = sueldo;
    }

    public Administrativo(Documento doc) {
        super(doc);
        fechaCargo = setFechaCargo();
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
    }

    // metodos
    @Override
    public String toString() {
        return super.toString() + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo;
    }

    public static Administrativo modificar(Administrativo a) {// modificar una estructura ya cargada
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