package DaliborJankovic.StudentskiServis.forms;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfessorForm {
    private String subjectName;
    private List<Professor> selectedProfessors;
}
