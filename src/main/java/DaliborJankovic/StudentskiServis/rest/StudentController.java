package DaliborJankovic.StudentskiServis.rest;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {


    private StudentService studentService;
    public StudentController(StudentService theStudentService) {studentService = theStudentService;}

    @GetMapping("/list")
    public String homePage(Model model) {

        List<Student> studentsList = studentService.findAll();

        model.addAttribute("studentsList", studentsList);

        return "students/student-list";
    }

    @GetMapping("/addStudents")
    public String addStudents(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "students/add-student";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") String id, Model theModel) {

        // get the employee from the service
        Student theStudent = studentService.findById(id);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form

        return "students/add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {

        // save the employee
        studentService.save(theStudent);

        // use a redirection to prevent duplicate submissions
        return "redirect:/students/list";
    }

    @GetMapping("/deleteStudent")
    public  String delete(@RequestParam("studentId") String id){

        //delete the employee
        studentService.deleteById(id);

        // redirect to the /employees/list
        return "redirect:/students/list";
    }


}
