public class Documento {
    private String tipoDocumento;
    private String numDocumento;

    public Documento(String tipoDocumento, String numDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    public static int verificarDocumneto(String tipoDocumento) {
        if (tipoDocumento.equals("DNI") || tipoDocumento.equals("PAS")  || tipoDocumento.equals("LE") || tipoDocumento.equals("CI"))
            return 0;
        return 1;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
}
