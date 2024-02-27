package BD.NN.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String studentName;
    private String studentDni;

    /* creo que deveriahacer un private List<Profesor>profesor; para determinar que profesor
    tiene el alumno para determinada mataria ya que varios profesores pueden dar la misma
    materia a distintos alumnos.
     */
}
