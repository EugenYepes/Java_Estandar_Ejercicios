import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import excepciones.FechaException;

public class Profesor extends Persona {
    private String fechaCargo;
    private int sueldo;
    private List<Curso> listaCursos = new ArrayList<Curso>();

    // constructor
    public Profesor() {
        super();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la fecha de ingreso al cargo:");
                fechaCargo = scan.next();
                int retorno = verificarFecha(fechaCargo);
                if (retorno != 0)
                    throw new FechaException(retorno);
                break;
            } catch (FechaException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
        System.out.println("Ingrese el sueldo:");
        sueldo = scan.nextInt();
        System.out.println("Ingrese la lista de cursos a los que esta asignado, finalizar con un 0");
        for (int i = 0;; i++) {
            Curso curso = new Curso(scan.next());
            listaCursos.add(curso);
            Curso.todosLosCursos.add(curso);
            if (listaCursos.get(i).getCurso().equals("0")) {
                listaCursos.remove(i);
                break;
            }
        }
    }

    // metodos
    @Override
    public String toString() {
        String listaCursosAux = new String();
        for (int i = 0; i < listaCursos.size(); i++) {
            listaCursosAux = listaCursosAux + listaCursos.get(i).getCurso() + " " + listaCursos.get(i).getId() + ", ";
        }
        return super.toString() + "\nEsta en el cargo desde: " + fechaCargo + "\nCobra: " + sueldo
                + "\nTiene a su cargo los siguientes cursos: " + listaCursosAux;
    }

    public static Profesor modificar(Profesor p) {// modificar el objeto ya cargado
        Profesor profNew = new Profesor();
        p = profNew;
        return p;
    }

    // getters & setters
    public String getFechaCargo() {
        return fechaCargo;
    }

    public void setFechaCargo(String fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}