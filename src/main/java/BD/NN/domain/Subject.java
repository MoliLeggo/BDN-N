package BD.NN.domain;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject {

    private String subjectName;
    private String dniTeacherInCharge;
    private String idSubject;//hago esto para usarlo de nexo en las busquedas key
    private List<Student>students;
    //private List<Profesor>profesores; en caso de que 1 asignatura pueda tener varios profesores

}
