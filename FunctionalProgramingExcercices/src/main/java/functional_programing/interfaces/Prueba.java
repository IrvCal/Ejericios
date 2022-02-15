package functional_programing.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * En esta interfaz se pone en practica ejercicio
 * del libro Modern Java pagina 53
 */
@FunctionalInterface
public interface Prueba{
    String process(BufferedReader n) throws IOException;
}
