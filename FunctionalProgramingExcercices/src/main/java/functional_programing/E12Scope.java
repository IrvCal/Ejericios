package functional_programing;

import java.util.stream.IntStream;

/**
 * En este ejemplo se mira el scope que tiene
 * un atributo que no puede ser empleado y los
 * que si, dentro de las lambdas
 */
public class E12Scope {
    private static double num1;
    private double num2;
    public static void main(String[] args) {
    }

    public void compruebaScope(){
        double num3 = 0;
        IntStream.rangeClosed(0,10).forEach(value -> {
//            num3 = 3;//este tipo de implementaicones ya lo habia querido hacer pero resulta que
            //el SCOPE tiene que ser global para poder aplicar cambios a una variable dentro de una lmbda
            num1 = 1;
            num2 = 2;
        });
    }
}
