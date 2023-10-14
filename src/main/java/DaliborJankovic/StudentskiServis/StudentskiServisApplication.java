package DaliborJankovic.StudentskiServis;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.service.ProfessorService;
import DaliborJankovic.StudentskiServis.service.StudentService;
import DaliborJankovic.StudentskiServis.service.SubjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentskiServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentskiServisApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService,
											   ProfessorService professorService,
											   SubjectService subjectService){

		return runner -> {

//			createStudent (studentService);
//			deleteStudent (studentService);

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
