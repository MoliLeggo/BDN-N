package BD.NN.infraestructure.repositories;

import BD.NN.domain.Student;
import BD.NN.domain.Subject;

public class StudentAdapter {
// lo quito para ver si logro hacerlo sin el Subject subject,
    public StudentEntity toStudentEntity(Student student) {
        return new StudentEntity(
                //subject.getIdSubject(),
                student.getStudentName(),
                student.getStudentDni()
        );
    }
    public Student toStudentDomain(StudentEntity studentEntity){
        return new Student(
                studentEntity.getStudentName(),
                studentEntity.getStudentDni()
        );
    }
}
