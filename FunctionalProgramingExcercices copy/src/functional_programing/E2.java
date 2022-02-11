package functional_programing;

import functional_programing.model.Course;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class E2 {
    private static List<Course> courses = List.of(new Course("Spring", "Framework", 95 , 20000),
            new Course("Spring Boot", "Framework", 96, 18000),
            new Course("API", "Microservices", 97, 22000),
            new Course("Microservices", "Microservices", 96, 25000),
            new Course("FullStack", "FullStack", 91, 140000),
            new Course("AWS", "Cloud", 99, 21000),
            new Course("Azure", "Cloud", 99, 21000),
            new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernetes", "Cloud", 101, 2000));
    public static void main(String[] args) {
//        cursosConLaMenorCantidadDeLetrasEnNombre();
        ordenarPorCategoria();
    }

    /**
     * Tiene un stream anidado para poder hacer la operacion
     *
     * tambien tiene la integracion de una linea para buscar cual de los cursos
     * arrojados es el de la calificacion mas alta
     */
    private static void cursosConLaMenorCantidadDeLetrasEnNombre(){

        long time = System.currentTimeMillis();
        System.out.println(
            courses.stream()
                    .filter(
                            course -> course.getName().length() ==
                                            courses.stream().mapToInt(e -> e.getName().length()).min().orElse(0)
                    )
//                    .parallel()//Mac: 248 Win:80 por alguna extrania razon no baja el tiempo de ejecucion al contrario lo hace mas tardado
//                    .forEach(System.out::println);
                    //.collect(Collectors.toList()) [Course{name='API', category='Microservices', reviewScore=97, numberOfStudents=22000}, Course{name='AWS', category='Cloud', reviewScore=92, numberOfStudents=21000}]
//                    .max(Comparator.comparingLong(Course::getReviewScore))//;//Obtiene el curso con la menor cantidad de letras y ademas con la mejor calificacion, se puede decir que usa DOS criterios de busqueda
                    .max(Comparator.comparingLong(E2::longitudMaximaCategoria))//Mac: 184 Win: 60
                    .stream().parallel().collect(Collectors.toList())//Mac:130 Win: 50 hasta aqui si hace mas rapido el proceso pero no por mucho mucho, en este caso vale la pena quitar esta linea y el paralel anterior
        );

        System.out.println(System.currentTimeMillis()-time);
    }

    /**
     * Ejercicio sacado del proyecto functional-programing 28minutes
     * -c_custom_clases
     *  -FP02MapCC
     *      -linea 66
     */
    private static void ordenarPorCategoria(){
        Map<String,List<String>> cursosPorCategoria=
        courses.stream()
                .collect(
                        //1. Se indica que se quiere colectar en un mapa
                        Collectors.groupingBy(
                                //2.se indica la kay del mapa
                                Course::getCategory,
                                //3.se indica el value (que en este caso va a ser una lista)
                                Collectors.mapping(
                                        //4.El valor de la lista (en este caso)
                                        Course::getName
                                        //5.Como se quiere que salga esta colleccion
                                        ,Collectors.toList()
                                )
                        )
                );
        System.out.println(cursosPorCategoria);
    }
    private static long longitudMaximaCategoria(Course c){
        return c.getCategory().length();
    }
}
