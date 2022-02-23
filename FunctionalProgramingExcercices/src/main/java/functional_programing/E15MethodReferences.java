package functional_programing;

import functional_programing.model.Course;

import java.util.List;
import java.util.function.*;

/**
 * En esta clase se va a pasar de lambda a
 * MethodReferences
 */
public class E15MethodReferences {
    public static void main(String[] args) {
        ToIntFunction<String> stringToInt =
//                value -> Integer.parseInt(value);
            Integer::parseInt;
        BiPredicate<List<String>,String> contains =
//                (list, value) -> list.contains(value);
                    List::contains;
        /**
         * Referencia a constructores
         */
        Supplier<Course> course = Course::new;//tiene que ser un supplier para que se pueda utilizar esta instancioacion (prefiero Builder)
        System.out.println(course.get());

    }
}
