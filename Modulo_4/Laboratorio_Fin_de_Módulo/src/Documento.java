public class Documento {
    private String tipoDocumento;
    private String numDocumento;

    public Documento(String tipoDocumento, String numDocumento){
        this.tipoDocumento=tipoDocumento;
        this.numDocumento=numDocumento;
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
