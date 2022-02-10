package functional_programing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 1. Cuente el número de letras minúsculas en una cadena (pista: vea el método de caracteres de los objetos de cadena).
 2. En una lista de cadenas, busque la cadena que contiene las letras más minúsculas. Para una lista vacía, regrese Opcional
 objeto <String>
 */
public class E1 {

    public static void main(String[] args) {
//        System.out.println( uno("STrinG"));
    dos();
    }

    public static long uno(String s){
       return s.chars().filter(Character::isLowerCase).count();
    }
    public static void dos(){
        List<Course> courses = List.of(new Course("Spring", "Framework", 99 , 20000),
                new Course("Spring Boot", "Framework", 96, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        Comparator<Course> numberOfLetters = Comparator.comparing(Course::getName);

        System.out.println(courses.stream().map(Course::getName).collect(Collectors.toList()));
        System.out.println(courses.stream().map(c-> c.getName() + " "+c.getName().length()).collect(Collectors.toList()));

    }
}
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public Course() {
    }

    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}