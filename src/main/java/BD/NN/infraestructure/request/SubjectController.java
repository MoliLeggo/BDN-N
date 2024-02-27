package BD.NN.infraestructure.request;

import BD.NN.aplication.SubjectService;
import BD.NN.domain.Student;
import BD.NN.domain.Subject;
import BD.NN.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /* Metodo para meter una asignatura a la BD

     */

    @PostMapping("Subject")
    public void saveSignature(@RequestBody CreateSubjectRequest request){
        List<Student> students = new ArrayList<>();
        for (CreateStudentRequest createStudentRequest : request.getStudentRequests()){
            Student student= new Student(
                    createStudentRequest.getStudentName(),
                    createStudentRequest.getStudentDni()
            );
            students.add(student);
        }

        //creo el objeto teacher
        Teacher teacher = new Teacher(
                request.getCreateTeacherRequest().getTeacherName(),
                request.getCreateTeacherRequest().getDni()
        );



        Subject subject = new Subject(
                request.getSubjectName(),
                request.getCreateTeacherRequest().getDni(),//añado el dni del teacher correspondiente
                request.getIdSubject(),
                students
        );
        subjectService.saveSubject(subject, teacher);
    }

}
