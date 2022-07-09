package Principales;
import enumerados.TiposDocumento;

public class Documento {
    private TiposDocumento tipoDocumento;
    private String numDocumento;
    private static int hash = 0;
    private int numHash;

    public Documento(TiposDocumento tipoDocumento, String numDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    @Override
    public int hashCode() {
        numHash = hash;
        hash++;
        return numHash;
    }

    public TiposDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TiposDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
}