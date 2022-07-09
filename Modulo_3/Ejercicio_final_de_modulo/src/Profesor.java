public class Profesor extends Persona {

    private int sueldo;

    public Profesor() {
            super();
        }

    public Profesor (String nombre, String apellido, String tipoDocumento, String numeroDocumento, int sueldo) {
            super(nombre, apellido, tipoDocumento, numeroDocumento);// Siempre debe ir primero
            this.sueldo = sueldo;
        }

    public static void mostrarDatos(Profesor[] profes) {
        System.out.println("mostrarDatos Alumno");
        for (int i = 0; i < profes.length; i++) {
            System.out.println("\nPersona ID: " + profes[i].getId()); // forma de guardar el id que declare como static
            System.out.println("Nombre: " + profes[i].getNombre());
            System.out.println("Apellido: " + profes[i].getApellido());
            System.out.println("Tipo de documento: " + profes[i].getDocumento().getTipo());
            System.out.println("Numero de documento: " + profes[i].getDocumento().getNumero());
            System.out.println("Edad (inventada): " + profes[i].getEdad());
            System.out.println("El profesor cobra: " + profes[i].getSueldo());
            if (profes[i].getEdad() >= 18) {
                System.out.println("y es mayor de edad");
            } else {
                System.out.println("y es menor de edad");
            }
        }
        System.out.println("\nLa cantidad de profesores ingresadas es: " + profes.length);
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
