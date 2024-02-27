package BD.NN.aplication;

import BD.NN.domain.Subject;
import BD.NN.domain.Teacher;
import BD.NN.infraestructure.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public void saveSubject(Subject subject, Teacher teacher){
        subjectRepository.saveSubject(subject, teacher);
    }
}
