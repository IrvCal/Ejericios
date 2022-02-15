package functional_programing;

import functional_programing.interfaces.Prueba;
import functional_programing.interfaces.PruebaConInt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E14UsingFunctionalInterfaces {

    public static void main(String[] args) throws IOException {
//        String a = processFile(n -> n.readLine());
        String numeroS = "1";
        String numero = processNumero(n -> String.valueOf(n = Integer.parseInt(numeroS)));
        System.out.println(numero);
    }
    public static String processFile(Prueba p) throws IOException {
        return  p.process(new BufferedReader(new FileReader("")));
    }
    public static String processNumero(PruebaConInt p) {
        return  p.processInt(2);
    }
}
