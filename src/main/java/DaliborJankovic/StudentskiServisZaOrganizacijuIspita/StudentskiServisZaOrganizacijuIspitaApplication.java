package DaliborJankovic.StudentskiServisZaOrganizacijuIspita;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.StudentRepository;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service.ProfessorService;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service.StudentService;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service.SubjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentskiServisZaOrganizacijuIspitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentskiServisZaOrganizacijuIspitaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService,
											   ProfessorService professorService,
											   SubjectService subjectService){

		return runner -> {

			//createStudent (studentService);
			//deleteStudent (studentService);

		};
	}

	private void deleteStudent(StudentService studentService) {

		studentService.deleteById(1);

	}

	private void createStudent(StudentService studentService) {

		Student newStudent = new Student();

		newStudent.setIndexNumber("1001");
		newStudent.setIndexYear(2023);
		newStudent.setFirstName("Dalibor");
		newStudent.setLastName("Jankovic");
		newStudent.setEMail("dalibor@gmail.com");
		newStudent.setAddress("Sv. Cirila i Metodija 42");
		newStudent.setCurrentYearOfStudy(1);

		studentService.save(newStudent);

	}

}
