import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File filePath = new File("./src/archivo.txt");
        // cargar desde la consola
        String input = " ";
        System.out.println("Ingrese un texto, finalice con 0");
        while (input.charAt(input.length() - 1) != '0') {
            input = input + '\n';
            input = input + scan.nextLine();
        }
        // eliminar el 0 al final de la string
        input=input.substring(0, (input.length()-1));
        // guardar en el archivo
        try {
            FileWriter fw = new FileWriter(filePath, true);// flag para que escriba al final del archivo y no sobreescriba
            fw.write(input);
            fw.close();
        } catch (FileNotFoundException FNFE) {
            System.err.println(FNFE);
        } catch (IOException IOE) {
            System.err.println(IOE);
        }

        // mostrar contenido del archivo con Buffered
        try {
            BufferedReader leerArchivo = new BufferedReader(new FileReader(filePath));
            String contenido = null;
            if (leerArchivo.ready()) {
                while ((contenido = leerArchivo.readLine()) != null) {
                    System.out.println(contenido);
                }
            }
            leerArchivo.close();
        } catch (FileNotFoundException FNFE) {
            System.err.println(FNFE);
        } catch (IOException IOE) {
            System.err.println(IOE);
        }
        scan.close();
    }
}