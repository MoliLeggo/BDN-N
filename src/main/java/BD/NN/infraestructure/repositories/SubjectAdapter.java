package BD.NN.infraestructure.repositories;

import BD.NN.domain.Student;
import BD.NN.domain.Subject;
import BD.NN.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdapter {

    StudentAdapter studentAdapter = new StudentAdapter();

    public SubjectEntity toSubjectEntity(Subject subject, Teacher teacher){

        subject.setDniTeacherInCharge(teacher.getDni());

        return new SubjectEntity(
                subject.getSubjectName(),
                subject.getDniTeacherInCharge(),
                subject.getIdSubject()
        );
    }
    public Subject toDomainSubject(SubjectEntity subjectEntity, List<StudentEntity>studentEntities){

        List<Student>studentsToDomain = new ArrayList<>();

        for (StudentEntity studentEntity : studentEntities){
            Student student = studentAdapter.toStudentDomain(studentEntity);
            studentsToDomain.add(student);
        }


        return new Subject(
                subjectEntity.getSubjectName(),
                subjectEntity.getDniTeacherInCharge(),
                subjectEntity.getIdSubject(),
                studentsToDomain
        );
    }
}
