package BD.NN.infraestructure.repositories;


import BD.NN.domain.Student;
import BD.NN.domain.Subject;
import BD.NN.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class SubjectRepository {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    private SubjectAdapter subjectAdapter = new SubjectAdapter();
    private StudentAdapter studentAdapter = new StudentAdapter();
    private TeacherAdapter teacherAdapter = new TeacherAdapter();


    public void saveSubject(Subject subject, Teacher teacher) {

        SubjectEntity subjectEntity = subjectAdapter.toSubjectEntity(subject, teacher);
        saveSubjectEntity(subjectEntity);

        for (Student student : subject.getStudents()) {
            StudentEntity studentEntity = studentAdapter.toStudentEntity(student);
            saveStudentEntity(studentEntity);
        }
        TeacherEntity teacherEntity = teacherAdapter.toTeacherEntity(teacher);
        saveTeacherEntity(teacherEntity);

    }

    public void saveSubjectEntity(SubjectEntity subjectEntity) {
        String query = "INSERT INTO subject(subjectName, dniTeacherInCharge, idSubject)" +
                " VALUES(:subjectName, :dniTeacherInCharge, :idSubject";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("subjectName", subjectEntity.getSubjectName())
                .addValue("dniTeacherInCharge", subjectEntity.getDniTeacherInCharge())
                .addValue("idSubject", subjectEntity.getIdSubject());
        jdbc.update(query, parameterSource);

    }

    public void saveStudentEntity(StudentEntity studentEntity) {
        String query = "INSERT INTO student(studentName, studentDni)" +
                "VALUES(:studentName, :studentDni)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("studentName", studentEntity.getStudentName())
                .addValue("studentDni", studentEntity.getStudentDni());
        jdbc.update(query, parameterSource);
    }

    public void saveTeacherEntity(TeacherEntity teacherEntity) {
        String query = "INSERT INTO teacher(teacherName, dni)" +
                "VALUES(:teacherName, :dni)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("teacherName", teacherEntity.getTeacherName())
                .addValue("dni", teacherEntity.getDni());
        jdbc.update(query, parameterSource);

    }

}
