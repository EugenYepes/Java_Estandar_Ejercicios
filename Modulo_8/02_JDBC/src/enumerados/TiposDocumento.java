package enumerados;

public enum TiposDocumento {
    DNI("Documento nacional de identidad"), PAS("Pasaporte"), LE("Libreta de Enrolamiento"), CI("Cedula de Identidad");

    private String descripcion;

    private TiposDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
