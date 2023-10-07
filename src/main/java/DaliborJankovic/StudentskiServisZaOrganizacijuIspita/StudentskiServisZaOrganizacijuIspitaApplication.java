package DaliborJankovic.StudentskiServisZaOrganizacijuIspita;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.StudentRepository;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service.StudentService;
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
	public CommandLineRunner commandLineRunner(StudentService studentService){

		return runner -> {

			//createStudent (studentService);
			deleteStudent (studentService);

		};
	}

	private void deleteStudent(StudentService studentService) {

		studentService.delete(1);

	}

	private void createStudent(StudentService studentService) {

		Student newStudent = new Student();

		newStudent.setIndexNumber("100/06");
		newStudent.setIndexYear(2006);
		newStudent.setFirstName("Dalibor");
		newStudent.setLastName("Jankovic");
		newStudent.setEMail("dalibor@gmail.com");
		newStudent.setAddress("Sv. Cirila i Metodija 42");
		newStudent.setCurrentYearOfStudy(4);

		studentService.save(newStudent);

	}

}
