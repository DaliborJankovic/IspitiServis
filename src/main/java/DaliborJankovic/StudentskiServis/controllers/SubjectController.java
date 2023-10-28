package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.service.ProfessorService;
import DaliborJankovic.StudentskiServis.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectService subjectService;
    private ProfessorService professorService;

    public SubjectController(SubjectService subjectService, ProfessorService professorService) {
        this.subjectService = subjectService;
        this.professorService = professorService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Subject> theSubjectList = subjectService.findAll();
        model.addAttribute("subjectList", theSubjectList);
        return "/subjects/subject-form";
    }

    @GetMapping("{subjectId}")
    public String viewSubject(@PathVariable Long subjectId, Model theModel) {
        Subject theSubject = subjectService.findById(subjectId);
        theModel.addAttribute("subject", theSubject);
        return "subjects/details";
    }

    @GetMapping("/add")
    @Transactional
    public String addSubjects(Model theModel) {
        Subject theSubject = new Subject();
        theModel.addAttribute("subject", theSubject);
        return "subjects/add-subject-form";
    }

    @GetMapping("/update/{subjectId}")
    public String updateSubjects(@PathVariable Long subjectId, Model theModel) {
        Subject theSubject = subjectService.findById(subjectId);
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

    @GetMapping("/assign_professors")
    public String assignProfessor(@RequestParam("subjectId") Long id, Model theModel) {
        Subject theSubject = subjectService.findById(id);
        List<Professor> theProfessorList = professorService.findAll();
        theModel.addAttribute("subject", theSubject);
        theModel.addAttribute("professorList", theProfessorList);
        return "subjects/assign-professors";
    }

    @PostMapping("/{subjectId}/addProfessor/{professorId}")
    public String addProfessorToSubject(@PathVariable String professorId,
                                        @PathVariable Long subjectId) {
        Subject tempSubject = subjectService.findById(subjectId);
        if ((tempSubject.getProfessors().contains(professorService.findById(professorId)))) {
            return "redirect:/subjects/{subjectId}";
        } else {
            subjectService.addProfessorToSubject(professorId, subjectId);
        }
        return "redirect:/subjects/{subjectId}";
    }

    @PostMapping("/{subjectId}/removeProfessor/{professorId}")
    public String removeProfessorToSubject(@PathVariable String professorId,
                                           @PathVariable Long subjectId) {
        subjectService.deleteProfessorFromSubject(professorId, subjectId);
        return "redirect:/subjects/{subjectId}";
    }

}
