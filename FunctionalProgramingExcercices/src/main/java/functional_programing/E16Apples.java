package functional_programing;

import functional_programing.model.Apple;
import functional_programing.model.ColorEnum;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Ya se habian hecho otros ejercicios con esta clase,
 * revisar el libro y las notas
 */
public class E16Apples {
    public static void main(String[] args) {
        /**
         * PREDICATES
         */
        Predicate<Apple> redApple = apple -> apple.getColor().equals(ColorEnum.RED);
        Predicate<Apple> greenApple = apple -> apple.getColor().equals(ColorEnum.GREEN);
//        se puede hacer una NEGACION DIRECTA de un predicado ya establecido
        Predicate<Apple> notRedApple = redApple.negate();
//        Se pueden juntar predicados con .and()
        Predicate<Apple> heavyApple = apple -> apple.getWeight()>150;
        notRedApple.and(heavyApple);

//        Tambien se pueden hacer mas compociciones como
        redApple.or(greenApple).and(heavyApple);

    }
}
