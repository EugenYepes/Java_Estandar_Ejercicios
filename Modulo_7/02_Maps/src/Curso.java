import java.util.ArrayList;
import java.util.List;

public class Curso {
    public static List<Curso> todosLosCursos = new ArrayList<Curso>();
    private String curso;
    private int contador = 0;
    private int id;

    public Curso(String curso) {
        this.curso = curso;// si se repite el curso incrementa el ID
        for (int i = 0; i < todosLosCursos.size(); i++) {//deberia funcionar porque no sale del for hasta recorrerlo completo y los id mas altos estan al final.
            if (curso.equals(todosLosCursos.get(i).curso)) {
                contador = todosLosCursos.get(i).id;
            }
        }
        contador++;
        id = contador;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId(){
        return id;
    }
}