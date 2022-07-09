public class Main {
    public static void main(String[] argv) {
        int a = 4;
        int b = 2;
        int resultado = 0;
        funcional(a, b, resultado);
        comoSiempre(a, b, resultado);
    }

    public static void funcional(int a, int b, int resultado) {
        CalculadoraFuncional operacion;
        operacion = (numA, numB) -> numA + numB;
        resultado = operacion.operar(a, b);
        System.out.println("Sumar " + a + " + " + b + " = " + resultado);

        operacion = (numA, numB) -> numA * numB;
        resultado = operacion.operar(a, b);
        System.out.println("Multiplicar " + a + " * " + b + " = " + resultado);

        operacion = (numA, numB) -> numA - numB;
        resultado = operacion.operar(a, b);
        System.out.println("Restar " + a + " - " + b + " = " + resultado);

        operacion = (numA, numB) -> numA / numB;
        resultado = operacion.operar(a, b);
        System.out.println("Dividir " + a + " / " + b + " = " + resultado);

        operacion = (numA, numB) -> numA % numB;
        resultado = operacion.operar(a, b);
        System.out.println("Modulo " + a + " % " + b + " = " + resultado);
    }

    public static void comoSiempre(int a, int b, int resultado) {
        resultado = Operaciones.sumar(a, b);
        System.out.println("Sumar " + a + " + " + b + " = " + resultado);
        resultado = Operaciones.multiplicar(a, b);
        System.out.println("Multiplicar " + a + " * " + b + " = " + resultado);
        resultado = Operaciones.restar(a, b);
        System.out.println("Restar " + a + " - " + b + " = " + resultado);
        resultado = Operaciones.dividir(a, b);
        System.out.println("Dividir " + a + " / " + b + " = " + resultado);
        resultado = Operaciones.modulo(a, b);
        System.out.println("Modulo " + a + " % " + b + " = " + resultado);
    }
}