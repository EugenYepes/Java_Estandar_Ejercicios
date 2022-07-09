import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private String fechaNacimiento;

    public Persona() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        apellido = scan.next();
        while (true) {
            try {
                System.out.println("Ingrese el tipo de documento:");
                String tipoDocumento = scan.next();
                System.out.println("Ingrese el numero de documento:");
                String numDocumento = scan.next();
                int retorno = Documento.verificarDocumneto(tipoDocumento);
                if (retorno != 0)
                    throw new DocumentoException(retorno);
                documento = new Documento(tipoDocumento, numDocumento);
                break;
            } catch (DocumentoException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }

        while (true) {
            try {
                System.out.println("Ingrese la fecha de nacimiento: (dd/mm/aaaa)");
                fechaNacimiento = scan.next();
                int retorno = verificarFecha(fechaNacimiento);
                if (retorno != 0)
                    throw new FechaException(retorno);
                break;
            } catch (FechaException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    }

    // metodos
    public static String mostrarDatos(String nombre, String apellido, String tipoDocumento, String numDocumento,
            String fechaNacimiento) {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDocumento: "
                + tipoDocumento + ": " + numDocumento
                + "\nFecha de nacimiento: " + fechaNacimiento;
    }

    public static void quienSoy(Persona a) {
        System.out.println("Soy un: " + a);
        System.out.println("y me llamo: " + a.getNombre() + a.getApellido());
    }

    public static Persona[] add(Persona[] p, int n) {// n = numero de nuevos elementos
        Persona[] pAux = new Persona[p.length + n];
        for (int i = 0; i < p.length; i++)
            pAux[i] = p[i];
        return pAux;
    }

    public static Persona[] delete(Persona[] p, int n) {// n = numero del elemento a eliminar
        Persona[] pAux = new Persona[p.length - 1];
        for (int i = 0; i < pAux.length; i++) {
            if (i == n)
                i++;
            pAux[i] = p[i];
        }
        return pAux;
    }

    public static Persona modificar(Persona p) {// modificar el objeto ya cargado
        Persona perNew = new Persona();
        p = perNew;
        return p;
    }

    public static int verificarFecha(String fecha) {// se tiene que cumplir el formato dd/mm/aaaa y tienen que ser
        // caracteres numericos
        if (fecha.length() != 10)
            return 1;
        for (int i = 0; i < fecha.length(); i++) {
            if (i == 2 || i == 5) {
                if (fecha.charAt(i) != '/') {
                    return 2;
                }
            } else {
                if (fecha.charAt(i) < '0' || fecha.charAt(i) > '9') {
                    return 3;
                }
            }
        }
        int dia, mes, anio;
        String auxS;
        auxS = fecha.substring(0, 2);
        dia = Integer.valueOf(auxS);
        if (dia < 1 || dia > 31)
            return 4;
        auxS = fecha.substring(3, 5);
        mes = Integer.valueOf(auxS);
        if (mes < 1 || mes > 12)
            return 5;
        auxS = fecha.substring(6, 10);
        anio = Integer.valueOf(auxS);
        if (anio < 0 || anio > 2022)
            return 6;
        return 0;
    }

    // getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}