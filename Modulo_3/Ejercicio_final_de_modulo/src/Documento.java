public final class Documento {//final no se puede heredar
    private String tipo;
    private String numero;

    public Documento() {
    }
    public Documento(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
