import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import excepciones.FechaException;

public class Alumno extends Persona {
    private String fechaIngreso;
    private List<Curso> listaCursos = new ArrayList<Curso>();

    // constructor
    public Alumno() {
        super();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la fecha de ingreso a la institucion: (dd/mm/aaaa)");
                fechaIngreso = scan.next();
                int retorno = verificarFecha(fechaIngreso);
                if (retorno != 0)
                    throw new FechaException(retorno);
                break;
            } catch (FechaException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
        System.out.println("Ingrese la lista de cursos que esta cursando, finalizar con un 0");
        for (int i = 0;; i++) {
            Curso curso = new Curso(scan.next());
            listaCursos.add(curso);
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
            listaCursosAux = listaCursosAux + listaCursos.get(i).getCurso() + listaCursos.get(i).getId() + ", ";
        }
        return super.toString() + "\nEsta en el cargo desde: " + "\nCursa desde: " + fechaIngreso
        + "\nCursa " + listaCursosAux;
    }

    public static Alumno modificar(Alumno a) {// modificar una estructura ya cargada
        Alumno alumNew = new Alumno();
        a = alumNew;
        return a;
    }

    public static String[] add(String[] s, int n) {// n = numero de nuevos elementos
        String[] sAux = new String[n];
        for (int i = 0; i < s.length; i++)
            sAux[i] = s[i];
        return sAux;
    }

    // getter & setters
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}