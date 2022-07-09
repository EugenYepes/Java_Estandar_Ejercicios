
public class FechaException extends Exception {
    private int codigo;

    public FechaException(int codigo) {
        super();
        this.codigo = codigo;
    }

    public FechaException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        switch (codigo) {
            case 1:
                return "La longitud de la fecha no es la adecuada";
            case 2:
                return "No contiene / (slash) en las posiciones esperadas";
            case 3:
                return "Los caracteres no son numericos";
            case 4:
                return "Los dias pueden ser entre 1 y 31";
            case 5:
                return "Solo hay 12 meses";
            case 6:
                return "Se pueden usar anio del 0 al 2022";
            default:
                return super.getMessage();
        }
    }
}
