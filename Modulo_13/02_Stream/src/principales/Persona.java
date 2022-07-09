package principales;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import enumerados.TiposDocumento;
import excepciones.FechaException;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private String fechaNacimiento;
    private int edad;
    // guarda todos los documentos ingresados y carga los de la base de datos
    private static HashMap<Integer, Documento> documentos = new HashMap<Integer, Documento>();
    Scanner scan = new Scanner(System.in);

    public Persona() {
        System.out.println("Ingrese el nombre:");
        nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        apellido = scan.next();
        documento = setDocumento();
        fechaNacimiento = setFechaNacimiento();
    }

    public Persona(String nombre, String apellido, Documento documento, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        calcularEdad(fechaNacimiento);
    }

    public Persona(Documento doc) {
        System.out.println("Ingrese el nombre:");
        nombre = scan.next();
        System.out.println("Ingrese el apellido:");
        apellido = scan.next();
        documento = doc;
        fechaNacimiento = setFechaNacimiento();
    }

    // metodos
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDocumento: "
                + documento.getTipoDocumento().getDescripcion() + ": " + documento.getNumDocumento()
                + "\nFecha de nacimiento: " + fechaNacimiento;
    }

    public static void quienSoy(Persona a) {
        System.out.println("Soy un: " + a);
        System.out.println("y me llamo: " + a.getNombre() + a.getApellido());
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

    private int calcularEdad(String fechaNacimiento) {
        LocalDate fechaHoy = LocalDate.now();

        int dia = Integer.valueOf(fechaHoy.toString().substring(8, 10));
        int mes = Integer.valueOf(fechaHoy.toString().substring(5, 7));
        int anio = Integer.valueOf(fechaHoy.toString().substring(0, 4));
        int diasTotHoy = fechaToDias(dia, mes, anio);

        dia = Integer.valueOf(fechaNacimiento.substring(0, 2));
        mes = Integer.valueOf(fechaNacimiento.substring(3, 5));
        anio = Integer.valueOf(fechaNacimiento.substring(6, 10));
        int diasTotFechaNac = fechaToDias(dia, mes, anio);

        int edad = diasTotHoy - diasTotFechaNac;
        edad /= 365;
        return edad;
    }

    private int fechaToDias(int dia, int mes, int anio) {
        int diasTot = 0;
        for (int i = 0; i < anio; i++) {
            if (i % 4 == 0) {
                diasTot += 366;
            } else {
                diasTot += 365;
            }
        }
        for (int i = 1; i < mes; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    diasTot += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    diasTot += 30;
                    break;
                case 2:
                    if ((anio % 4) == 0) {
                        diasTot += 29;
                    } else {
                        diasTot += 28;
                    }
                    break;
                default:
                    break;
            }
        }
        diasTot += dia;
        return diasTot;
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

    public Documento setDocumento() {
        while (true) {
            try {
                System.out.println("Ingrese el tipo de documento:");
                TiposDocumento tipoDocumento = TiposDocumento.valueOf(scan.next().toUpperCase());
                System.out.println("Ingrese el numero de documento:");
                String numDocumento = scan.next();
                boolean seRepite = false;// si se repite un documento true
                for (int i = 0; i < documentos.size(); i++) {
                    if (tipoDocumento.equals(documentos.get(i).getTipoDocumento())
                            && numDocumento.equals(documentos.get(i).getNumDocumento()))
                        seRepite = true;
                }
                if (!seRepite) {// si no exite ese documento se guarda
                    documento = new Documento(tipoDocumento, numDocumento);
                    documentos.put(documento.hashCode(), documento);
                } else {
                    throw new Exception("ya existe otra persona con este documento");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
        return documento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        edad = calcularEdad(fechaNacimiento);
        this.fechaNacimiento = fechaNacimiento;
    }

    public String setFechaNacimiento(){
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
        edad = calcularEdad(fechaNacimiento);
        return fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static HashMap<Integer, Documento> getDocumentos() {
        return documentos;
    }

    public static void setDocumentos(HashMap<Integer, Documento> documentos) {
        Persona.documentos = documentos;
    }

    public void scanClose(){
        scan.close();
    }
}