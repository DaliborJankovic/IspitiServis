package DaliborJankovic.StudentskiServis.rest;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Subject> theSubjectList = subjectService.findAll();
        model.addAttribute("subjectList", theSubjectList);
        return "/subjects/subject-form";
    }

    @GetMapping("/add")
    public String addSubjects(Model theModel) {
        Subject theSubject = new Subject();
        theModel.addAttribute("subject", theSubject);
        return "subjects/add-subject-form";
    }

    @GetMapping("/update")
    public String updateSubjects(@RequestParam("subjectId") Long id, Model theModel) {
        Subject theSubject = subjectService.findById(id);
        theModel.addAttribute("subject", theSubject);
        return "subjects/add-subject-form";
    }

    @PostMapping("/save")
    public String saveSubject(@ModelAttribute("subject") Subject theSubject) {
        subjectService.save(theSubject);
        return "redirect:/subjects/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("subjectId") Long id) {
        subjectService.deleteById(id);
        return "redirect:/subjects/list";
    }

}
