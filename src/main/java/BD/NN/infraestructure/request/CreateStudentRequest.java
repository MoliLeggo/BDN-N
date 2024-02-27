package BD.NN.infraestructure.request;

import lombok.Data;

@Data
public class CreateStudentRequest {

    private String studentName;
    private String studentDni;
}
