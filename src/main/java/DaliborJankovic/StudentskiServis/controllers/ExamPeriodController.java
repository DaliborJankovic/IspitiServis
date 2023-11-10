package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.service.ExamPeriodService;
import DaliborJankovic.StudentskiServis.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam_period")
@RequiredArgsConstructor
public class ExamPeriodController {

    private final ExamPeriodService examPeriodService;
    private final ExamService examService;

    @GetMapping("/list")
    public String List(Model theModel) {
        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
        examPeriodService.isActive(theExamPeriodList, theModel);
        return "exams/exam-period-form";
    }

    @GetMapping("/activeRegList")
    public String activeRegPeriod(Model theModel) {
        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
        examPeriodService.validateRegistrationPeriod(theExamPeriodList, theModel);
        return "exams/active-exam-registration";
    }


//    @GetMapping("/activeList")
//    public String activeList(Model theModel) {
//        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
//        examPeriodService.isActive(theExamPeriodList, theModel);
//        return "exams/exam-period-form";
//    }

    @GetMapping("{examPeriodId}")
    public String viewExamPeriod(@PathVariable int examPeriodId, Model theModel) {
        ExamPeriod theExamPeriod = examPeriodService.findById(examPeriodId);
        List<Exam> exams = examService.findAllExamsInExamPeriod(theExamPeriod);
        theModel.addAttribute("examPeriod", theExamPeriod);
        theModel.addAttribute("examsList", exams);
        return "exams/exam-period-details";
    }

    @GetMapping("/addExamPeriod")
    public String addExamPeriod(Model theModel) {
        ExamPeriod theExamPeriod = new ExamPeriod();
        theModel.addAttribute("examPeriod", theExamPeriod);
        return "exams/add-exam-period-form";
    }

    @PostMapping("/save")
    public String SaveExamPeriod(@ModelAttribute("examPeriod") ExamPeriod theExamPeriod, Model theModel) {
        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
        List<String> errorMessages = examPeriodService.validateExamPeriod(theExamPeriodList, theExamPeriod);
        if (!errorMessages.isEmpty()) {
            theModel.addAttribute("errorMessages", errorMessages);
            return "error";
        }
        examPeriodService.save(theExamPeriod);
        return "redirect:/exam_period/list";
    }

}
