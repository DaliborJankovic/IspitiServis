package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamPeriodService examPeriodService;
    private final ExamService examService;
    private final SubjectService subjectService;
    private final ProfessorService professorService;

    @GetMapping("/addExam")
    public String addExam(Model theModel) {
        Exam theExam = new Exam();
        theModel.addAttribute("exam", theExam);
        examAttributes(theModel);
        return "exams/add-exam-form";
    }

    @GetMapping("/update/{examId}")
    public String updateExam(@PathVariable Long examId, Model theModel) {
        Exam theExam = examService.findById(examId);
        theModel.addAttribute("exam", theExam);
        examAttributes(theModel);
        return "exams/add-exam-form";
    }

    @PostMapping("/save")
    public String SaveExam(@ModelAttribute("exam") Exam theExam, Model theModel) {
        List<String> errorMessages = examService.validateExam(theExam);
        if (!errorMessages.isEmpty()) {
            theModel.addAttribute("errorMessages", errorMessages);
            return "error";
        }
        examService.save(theExam);
        return "redirect:/exam_period/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("examId") Long id) {
        examService.deleteById(id);
        return "redirect:/exam_period/list";
    }

    void examAttributes(Model model) {
        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
        List<Subject> theSubjectList = subjectService.findAll();
        List<Professor> theProfessorList = professorService.findAll();
        model.addAttribute("examPeriodList", theExamPeriodList);
        model.addAttribute("subjectList", theSubjectList);
        model.addAttribute("professorList", theProfessorList);
    }

}
