package BD.NN.infraestructure.request;

import lombok.Data;

@Data
public class CreateTeacherRequest {

    private String teacherName;
    private String dni;
}
