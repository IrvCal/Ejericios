package functional_programing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;
}