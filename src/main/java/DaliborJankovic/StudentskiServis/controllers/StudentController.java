package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.service.CityService;
import DaliborJankovic.StudentskiServis.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private CityService cityService;

    public StudentController(StudentService studentService, CityService cityService) {
        this.studentService = studentService;
        this.cityService = cityService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Student> theStudentsList = studentService.findAll();
        theStudentsList.sort(Comparator.comparing(Student::getIndexNumber));
        model.addAttribute("studentsList", theStudentsList);
        return "/students/student-form";
    }

    @GetMapping("{studentId}")
    public String viewStudent(@PathVariable String studentId, Model theModel) {
        Student theStudent = studentService.findById(studentId);
        theModel.addAttribute("student", theStudent);
        return "students/details";
    }

    @GetMapping("/add")
    public String addStudents(Model theModel) {
        Student theStudent = new Student();
        List<City> cities = cityService.findAll();
        theModel.addAttribute("title", "Add student");
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("cityList", cities);
        return "students/add-student-form";
    }

    @GetMapping("/update/{studentId}")
    public String updateStudent(@PathVariable String studentId, Model theModel) {
        Student theStudent = studentService.findById(studentId);
        List<City> cities = cityService.findAll();
        theModel.addAttribute("title", "Update student");
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("cityList", cities);
        return "students/add-student-form"; // ne moze redirect: --->> gubi se findById...
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {
        studentService.save(theStudent);
        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") String id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

}
