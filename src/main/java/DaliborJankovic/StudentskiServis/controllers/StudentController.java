package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.service.CityService;
import DaliborJankovic.StudentskiServis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CityService cityService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int pageSize,
                       @RequestParam(defaultValue = "asc") String sortDirection,
                       @RequestParam(defaultValue = "indexNo") String sortBy) {
        List<Student> theStudentsList = studentService.findAll();
        theStudentsList.sort(Comparator.comparing(Student::getIndexNumber));
        if(sortBy.equals("name")) {
            if(sortDirection.equals("asc")){
                theStudentsList.sort(Comparator.comparing(Student::getLastName));
            } else if (sortDirection.equals("desc")) {
                theStudentsList.sort(Comparator.comparing(Student::getLastName).reversed());
            }
        } else if (sortBy.equals("indexNo")) {
            if(sortDirection.equals("asc")){
                theStudentsList.sort(Comparator.comparing(Student::getIndexNumber));
            } else if (sortDirection.equals("desc")) {
                theStudentsList.sort(Comparator.comparing(Student::getIndexNumber).reversed());
            }
        }
        int totalStudents = theStudentsList.size();
        int totalPages = (int) Math.ceil((double) totalStudents / pageSize);
        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalStudents);
        List<Student> paginatedStudents = theStudentsList.subList(fromIndex, toIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("studentsList", paginatedStudents);
        model.addAttribute("pageSizeOptions", Arrays.asList(5, 10, 20));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
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
        return "students/add-student-form"; // ne moze redirect: --->> gubi se findById
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
