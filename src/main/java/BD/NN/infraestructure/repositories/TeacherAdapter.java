package BD.NN.infraestructure.repositories;

import BD.NN.domain.Teacher;

public class TeacherAdapter {

    public TeacherEntity toTeacherEntity(Teacher teacher) {

        return new TeacherEntity(
                teacher.getTeacherName(),
                teacher.getDni()
        );
    }
    static public Teacher toTeacherDomain(TeacherEntity teacherEntity){

        return new Teacher(
                teacherEntity.getTeacherName(),
                teacherEntity.getDni()
        );
    }
}
