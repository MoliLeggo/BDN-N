package BD.NN.infraestructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectEntity {

    private String subjectName;
    private String dniTeacherInCharge;
    private String idSubject;
}

