package DaliborJankovic.StudentskiServis;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import DaliborJankovic.StudentskiServis.enums.TeacherTitle;
import DaliborJankovic.StudentskiServis.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
                                               UserService userService,
                                               CityService cityService) {

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

        tempStudent.setUsername("Nikooo");
        tempStudent.setPassword("456");
        tempStudent.setIndexNumber("1003");
        tempStudent.setIndexYear(2023);
        tempStudent.setFirstName("Nikola");
        tempStudent.setLastName("Nikolic");
        tempStudent.setEMail("niko@gmail.com");
        tempStudent.setAddress("Lepenicka 66");
        City tempCity = new City();
        tempCity.setCityName("Kragujevac");
        tempCity.setPostCode(34000);
        tempStudent.setPostalCode(tempCity);
        tempStudent.setCurrentYearOfStudy(1);

        studentService.save(tempStudent);

    }

}
