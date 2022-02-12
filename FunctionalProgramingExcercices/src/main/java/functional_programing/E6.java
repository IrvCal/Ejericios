package functional_programing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Escribir una función que reciba una frase y
 * devuelva un diccionario con las palabras que contiene y su longitud.
 */
public class E6 {
    public static void main(String[] args) {
        List<String> dictionary=
                getDictionary("Elegimos para ti una colección de 150 frases cortas que puedes leer aleatoriamente, o por área en la que necesites una fuente de inspiración: frases de éxito, frases de la vida, frases de motivación personal, frases de amor, frases de superación personal, frases de motivación cortas. En resumen, frases inspiradoras que te lleven y apoyen al cambio que tan inevitablemente ocurre constantemente dentro de nosotros.");
        System.out.println(dictionary);
    }

    private static List<String> getDictionary(String s) {
        Stream<String> palabras = Arrays.stream(s.split(" "));
        return palabras.map(s1 -> s1 + ": "+s1.length()).collect(Collectors.toList());
    }
}
