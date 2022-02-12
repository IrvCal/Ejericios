package functional_programing;

import java.util.List;
import java.util.function.Function;

/**
 * Escribir una función reciba una lista
 * de notas y devuelva la lista de
 * calificaciones correspondientes a esas notas.
 */
public class E7 {
    public static void main(String[] args) {
        List<Integer> calificaciones = List.of(90,21,30,88,92,23,60,70);
        Function<Integer,String> calificacionesColocadas =
                integer -> integer<70? integer+": F":integer<80? integer+": B":integer<90? integer+": A":integer+": A+";
        calificaciones.stream().map(calificacionesColocadas).forEach(System.out::println);
    }
}
