package DaliborJankovic.StudentskiServis;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import DaliborJankovic.StudentskiServis.enums.TeacherTitle;
import DaliborJankovic.StudentskiServis.service.ProfessorService;
import DaliborJankovic.StudentskiServis.service.StudentService;
import DaliborJankovic.StudentskiServis.service.SubjectService;
import DaliborJankovic.StudentskiServis.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;

@SpringBootApplication
public class StudentskiServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentskiServisApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService,
											   ProfessorService professorService,
											   SubjectService subjectService,
											   UserService userService){

		return runner -> {

//			createStudent (studentService);
//			deleteStudent (studentService);
//			createProfessor (professorService);
//			deleteProfessor(professorService);
//			deleteUser (userService);

		};
	}




	private void deleteUser(UserService userService) {

		userService.deleteById("Dal");

	}

	private void deleteProfessor(ProfessorService professorService) {

		professorService.deleteById("Dal");

	}

	private void createProfessor(ProfessorService professorService) {

		Professor tempProfessor = new Professor();

		tempProfessor.setUsername("Petar_P");
		tempProfessor.setPassword("123");
		tempProfessor.setFirstName("Petar");
		tempProfessor.setLastName("Petrovic");
        tempProfessor.setEMail("petar@nesto.com");
        tempProfessor.setAddress("Glavna Ulica 15");
        tempProfessor.setPhoneNumber("0630011001");
		tempProfessor.setReelectionDate(LocalDate.of(2024, 10, 19));
		Title title = new Title();
		title.setTeacherTitle(TeacherTitle.PROFESSOR);
		tempProfessor.setTitle(title);

		professorService.save(tempProfessor);


	}

	private void deleteStudent(StudentService studentService) {

		studentService.deleteById("");

	}

	private void createStudent(StudentService studentService) {

		Student tempStudent = new Student();

		tempStudent.setUsername("Dali_j");
		tempStudent.setPassword("123456");
		tempStudent.setIndexNumber("1001");
		tempStudent.setIndexYear(2023);
		tempStudent.setFirstName("Dalibor");
		tempStudent.setLastName("Jankovic");
		tempStudent.setEMail("dalibor@gmail.com");
		tempStudent.setAddress("Sv. Cirila i Metodija 42");
		tempStudent.setCurrentYearOfStudy(1);

		studentService.save(tempStudent);

	}

}
