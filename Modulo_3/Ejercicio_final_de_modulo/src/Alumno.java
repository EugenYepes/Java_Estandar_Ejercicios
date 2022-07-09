public class Alumno extends Persona {// hereda de persona

    private String[] cursos;

    public Alumno() {
        super();
    }

    public Alumno(String nombre, String apellido, String tipoDocumento, String numeroDocumento) {
        super(nombre, apellido, tipoDocumento, numeroDocumento);// Siempre debe ir primero
    }

    public static void mostrarDatos(Alumno[] alum) {
        for (int i = 0; i < alum.length; i++) {
            System.out.println("\nPersona ID: " + alum[i].getId()); // forma de guardar el id que declare como static
            System.out.println("Nombre: " + alum[i].getNombre());
            System.out.println("Apellido: " + alum[i].getApellido());
            System.out.println("Tipo de documento: " + alum[i].getDocumento().getTipo());
            System.out.println("Numero de documento: " + alum[i].getDocumento().getNumero());
            System.out.println("Edad (inventada): " + alum[i].getEdad());
            System.out.println("Este alumno cursa " + alum[i].cursos.length + "cursos\nCursa:");
            for (int j = 0; j < alum[i].cursos.length; j++) {
                System.out.println(alum[i].cursos[j]);
            }
            if (alum[i].getEdad() >= 18) {
                System.out.println("y es mayor de edad");
            } else {
                System.out.println("y es menor de edad");
            }
        }
        System.out.println("\nLa cantidad de alum ingresadas es: " + alum.length);
    }

    public String[] getCursos() {
        return cursos;
    }

    public void setCursos(String[] cursos) {
        this.cursos = cursos;
    }
}