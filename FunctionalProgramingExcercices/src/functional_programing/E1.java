package functional_programing;

import functional_programing.model.Course;

import java.util.Comparator;
import java.util.List;

/**
 1. Cuente el número de letras minúsculas en una cadena (pista: vea el método de caracteres de los objetos de cadena).
 2. En una lista de cadenas, busque la cadena que contiene las letras más minúsculas. Para una lista vacía, regrese Opcional
 objeto <String>
 3.Obtener el curso con mas letras
 */
public class E1 {
   public static List<Course> courses = List.of(new Course("Spring", "Framework", 95 , 20000),
            new Course("Spring Boot", "Framework", 96, 18000),
            new Course("API", "Microservices", 97, 22000),
            new Course("Microservices", "Microservices", 96, 25000),
            new Course("FullStack", "FullStack", 91, 140000),
            new Course("AWS", "Cloud", 92, 21000),
            new Course("Azure", "Cloud", 99, 21000),
            new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernetes", "Cloud", 101, 2000));
    public static void main(String[] args) {
//        System.out.println( uno("STrinG"));
//        dos(List.of("aabbCC","aaBBCC","aaaaaaaaaaaaaaaaaaaa"));
        cursoConMasLetras();
    }

    public static void dos(List<String> strings){
        System.out.println(
        strings.stream().max(Comparator.comparingLong(E1::uno)));
        System.out.println(
                strings.stream().max((o1, o2) -> Math.min(o1.length(), o2.length()))
        );
        System.out.println(

        );

    }


    public static long uno(String s){
       return s.chars().filter(Character::isLowerCase).count();
    }
    public static void tres(){


        Comparator<Course> numberOfLetters = Comparator.comparing(Course::getName);

//        System.out.println(courses.stream().map(Course::getName).collect(Collectors.toList()));
//        System.out.println(courses.stream().map(c-> c.getName() + " "+c.getName().length()).collect(Collectors.toList()));

        System.out.println(
                "Maximo numero de letras: " +
                        courses.stream().mapToInt(e -> e.getName().length()).max().orElse(0)
        );
        System.out.println("Maximo numero de review: " +
                courses.stream()
                        .max((o1, o2) -> o1.getReviewScore()>o2.getReviewScore()? 1:0)
        );
        System.out.println("\n\n\nMaximo numero de letras: " +
                courses.stream()
                        .max((o1, o2) -> {
                            System.out.println("Compara: "+o1+ " con : " +o2);
                            System.out.println(o1.getName().length()>o2.getName().length()? 0:1);
                            return o1.getName().length()>o2.getName().length()? 0:1;
                        })
        );

        System.out.println(
        courses.stream().map(Course::getName)
                //                .sorted((o1, o2) ->  o1.length()<o2.length()? 0:1).collect(Collectors.toList())
        );

    }

    /**
     * El curso con mayor cantidad de letras
     */
    public static void cursoConMasLetras(){

        System.out.println(
                courses.stream()
                        .min(Comparator.comparingLong(E1::palabraNumLetras))// se puede poner una lambda tal value -> value.getName().length()) en este caso creo que estaria mejor para no hacer un metodo aparte
//                        .max(Comparator.comparing(Course::getNumberOfStudents))//regresa el curso con mayor cantidad de estudiantes
        );
    }

    public static int palabraNumLetras(Course course){
        return course.getName().length();
    }
}
