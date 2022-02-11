package functional_programing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class E2 {
    public static List<Course> courses = List.of(new Course("Spring", "Framework", 95 , 20000),
            new Course("Spring Boot", "Framework", 96, 18000),
            new Course("API", "Microservices", 97, 22000),
            new Course("Microservices", "Microservices", 96, 25000),
            new Course("FullStack", "FullStack", 91, 140000),
            new Course("AWS", "Cloud", 99, 21000),
            new Course("Azure", "Cloud", 99, 21000),
            new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernetes", "Cloud", 101, 2000));
    public static void main(String[] args) {
        cursosConLaMenorCantidadDeLetrasEnNombre();
    }

    /**
     * Tiene un stream anidado para poder hacer la operacion
     *
     * tambien tiene la integracion de una linea para buscar cual de los cursos
     * arrojados es el de la calificacion mas alta
     */
    public static void cursosConLaMenorCantidadDeLetrasEnNombre(){

        long time = System.currentTimeMillis();
        System.out.println(
            courses.stream()
                    .filter(
                            course -> course.getName().length() ==
                                            courses.stream().mapToInt(e -> e.getName().length()).min().orElse(0)
                    )
//                    .parallel()//por alguna extrania razon no baja el tiempo de ejecucion al contrario lo hace mas tardado
//                    .forEach(System.out::println);
                    //.collect(Collectors.toList()) [Course{name='API', category='Microservices', reviewScore=97, numberOfStudents=22000}, Course{name='AWS', category='Cloud', reviewScore=92, numberOfStudents=21000}]
//                    .max(Comparator.comparingLong(Course::getReviewScore))//;//Obtiene el curso con la menor cantidad de letras y ademas con la mejor calificacion, se puede decir que usa DOS criterios de busqueda
                    .max(Comparator.comparingLong(E2::longitudMaximaCategoria))
                    .stream().parallel().collect(Collectors.toList())// hasta aqui si hace mas rapido el proceso pero no por mucho mucho, en este caso vale la pena quitar esta linea y el paralel anterior
        );

        System.out.println(System.currentTimeMillis()-time);
    }
    public static long longitudMaximaCategoria(Course c){
        return c.getCategory().length();
    }
}
