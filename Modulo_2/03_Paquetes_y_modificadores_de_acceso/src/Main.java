
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Eugenio", "Yepes", "DNI", "12345678");
        System.out.println("Nombre:" + persona1.nombreCompleto());
        System.out.println("Tipo de documento: " + persona1.doc.tipoDocumento);
        System.out.println("Numero de documento: " + persona1.doc.numeroDocumento);
        System.out.println(persona1.mayorEdad());
        System.out.print("\n");
    }
}
