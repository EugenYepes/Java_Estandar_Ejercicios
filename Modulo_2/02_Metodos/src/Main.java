
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Eugenio", "Yepes", "DNI", "12345678", 20, "miCasa", 1111);
        System.out.println("Nombre:" + persona1.nombre);
        System.out.println("Apellido: " + persona1.apellido);
        System.out.println("Tipo de documento: " + persona1.tipoDocumento);
        System.out.println("Numero de documento: " + persona1.numeroDocumento);
        System.out.println("Edad: " + persona1.edad);
        System.out.println("Calle: " + persona1.domicilio.calle);
        System.out.println("Numero: " + persona1.domicilio.numero);
        if (persona1.edad >= 18) {
            System.out.println("Es mayor de edad");
        }
        System.out.print("\n");
    }
}
