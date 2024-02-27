package BD.NN.infraestructure.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateSubjectRequest {

    CreateTeacherRequest createTeacherRequest = new CreateTeacherRequest();

    private String subjectName;
    //private String dniTeacherInCharge ;
    private String idSubject;
    private List<CreateStudentRequest>studentRequests;


    public CreateTeacherRequest getCreateTeacherRequest(CreateTeacherRequest createTeacherRequest) {
        return createTeacherRequest;
    }


}
