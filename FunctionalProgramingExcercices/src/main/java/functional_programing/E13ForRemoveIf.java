package functional_programing;

import functional_programing.model.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E13ForRemoveIf {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
           courses.addAll(//se tuvo que agregar esto porque igualando directamente la lista a esto la hace Imutable
                List.of(new Course("Spring", "Framework", 95 , 20000),
                new Course("Spring Boot", "Framework", 96, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 140000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 101, 2000))
           );
           courses.forEach(System.out::println);
        System.out.println("------- Duespues de la eliminacion");
           courses.removeIf(E13ForRemoveIf::menorA95);
           courses.forEach(System.out::println);
    }
    public static boolean menorA95(Course course){
        return course.getReviewScore()<95;
    }
}
