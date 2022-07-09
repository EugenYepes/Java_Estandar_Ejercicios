public class Persona {
    String nombre;
    String apellido;
    String tipoDocumento;
    String numeroDocumento;
    int edad;
    Domicilio domicilio;// crear atributo propio

    public Persona(String miCalle, int miNumero){
        System.out.println("constructor de domicilio en persona");
        domicilio = new Domicilio(miCalle, miNumero);
    }
    public Persona(String miNombre, String miApellido, String miTipoDocumento, String miNumeroDocumento, int miEdad, String miCalle, int miNumero){
        domicilio = new Domicilio(miCalle, miNumero);
        nombre = miNombre;
        apellido = miApellido;
        tipoDocumento = miTipoDocumento;
        numeroDocumento = miNumeroDocumento;
        edad = miEdad;

    }
    //los metodos reciben parametros
    public String dameTuNombreCompleto() {//retorna el nombre y el apellido
        return nombre + ", " + apellido;

    }

    
}
