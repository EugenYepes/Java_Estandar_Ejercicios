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
        while (verificarFecha(fechaCargo) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            fechaCargo = scan.next();
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        d.setNombre(scan.next());
        System.out.println("Ingrese el apellido:");
        d.setApellido(scan.next());
        System.out.println("Ingrese el tipo de documento:");
        String tipoDoc = scan.next();
        System.out.println("Ingrese el numero de documento:");
        String numDoc = scan.next();
        System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
        d.setFechaNacimiento(scan.next());
        while (verificarFecha(d.getFechaNacimiento()) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            d.setFechaNacimiento(scan.next());
        }
        Documento documento = new Documento(tipoDoc, numDoc);
        d.setDocumento(documento);

        System.out.println("Ingrese la fecha de ingreso al cargo:");
        d.setFechaCargo(scan.next());
        while (verificarFecha(d.getFechaCargo()) == false) {
            System.out.println("Vuelva a ingresar la fecha correctamente");
            d.setFechaCargo(scan.next());
        }
        System.out.println("Ingrese la carrera de la cual es director:");
        d.setCarrera(scan.next());
        System.out.println("Ingrese el sueldo:");
        d.setSueldo(scan.nextInt());
        return d;
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
