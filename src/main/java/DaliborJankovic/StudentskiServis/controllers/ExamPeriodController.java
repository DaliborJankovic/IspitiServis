package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.service.ExamPeriodService;
import DaliborJankovic.StudentskiServis.service.ExamRegistrationService;
import DaliborJankovic.StudentskiServis.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam_period")
public class ExamPeriodController {

    private ExamPeriodService examPeriodService;
    private ExamService examService;
    private ExamRegistrationService examRegistrationService;

    public ExamPeriodController(ExamPeriodService examPeriodService, ExamService examService,
                                ExamRegistrationService examRegistrationService) {
        this.examPeriodService = examPeriodService;
        this.examService = examService;
        this.examRegistrationService = examRegistrationService;
    }

    @GetMapping("/list")
    public String List (Model model) {
        List<ExamPeriod> theExamPeriodList = examPeriodService.findAll();
        model.addAttribute("examPeriodList", theExamPeriodList);
        return "exam-period-form";
    }

}
