public class DocumentoException extends Exception{
    private int codigo;

    public DocumentoException(int codigo) {
        super();
        this.codigo = codigo;
    }

    public DocumentoException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        switch (codigo) {
            case 1:
                return "Solo se soportan documentos del tipo DNI, PAS, LE, CI";
            default:
                return super.getMessage();
        }
    }
}
