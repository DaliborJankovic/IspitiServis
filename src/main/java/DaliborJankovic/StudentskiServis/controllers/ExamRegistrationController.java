package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.service.ExamPeriodService;
import DaliborJankovic.StudentskiServis.service.ExamRegistrationService;
import DaliborJankovic.StudentskiServis.service.ExamService;
import DaliborJankovic.StudentskiServis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/examRegistration")
@RequiredArgsConstructor
public class ExamRegistrationController {

    private final ExamRegistrationService examRegistrationService;
    private final StudentService studentService;
    private final ExamService examService;
    private final ExamPeriodService examPeriodService;


    @GetMapping("/list{examId}")
    public String List(@PathVariable Long examId, Model theModel) {
        Exam theExam = examService.findById(examId);
        List<ExamRegistration> theExamRegistrationList = examRegistrationService
                .findAllExamsRegistrationsInExam(theExam);
        theModel.addAttribute("exam", theExam);
        theModel.addAttribute("examRegistrationList", theExamRegistrationList);
        return "exams/exam-registration-form";
    }

    @GetMapping("/newExamRegistration")
    public String newExamRegistration(@RequestParam("examPeriodId") int epId, Model theModel) {
        List<String> errorMessages = examRegistrationService.dateValidation(examPeriodService.findById(epId));
        if (!errorMessages.isEmpty()) {
            theModel.addAttribute("errorMessages", errorMessages);
            return "error";
        }
        ExamRegistration theExamRegistration = new ExamRegistration();
        theModel.addAttribute("examRegistration", theExamRegistration);
        examRegistrationAttributes(epId, theModel);
        return "exams/new-exam-registration-form";
    }

    @GetMapping("/multiExamRegistration")
    public String multiExamRegistration(@RequestParam("examPeriodId") int epId, Model theModel) {
        ExamRegistration theExamRegistration = new ExamRegistration();
        theModel.addAttribute("examRegistration", theExamRegistration);
        examRegistrationAttributes(epId, theModel);
        return "exams/multi-exam-registration-form";
    }

//    @GetMapping("/grade/{examRegistrationId}")
//    public String grade (@PathVariable Long examRegistrationId,
//                                       @RequestParam("examPeriodId") int epId,Model theModel) {
//        ExamRegistration theExamRegistration = examRegistrationService.findById(examRegistrationId);
//        theModel.addAttribute("examRegistration", theExamRegistration);
//        examRegistrationAttributes(epId, theModel);
//        return "exams/new-exam-registration-form";
//    }

    @PostMapping("/saveAll")
    public String saveAllExamRegistrations(@RequestParam("studentId") String studentId,
                                           @RequestParam("selectedExams") List<Long> selectedExamIds, Model theModel) {
        Student student = studentService.findById(studentId);
        for (Long examId : selectedExamIds) {
            Exam exam = examService.findById(examId);
            List<String> errorMessages = examRegistrationService.examValidation(student, exam);
            if (!errorMessages.isEmpty()) {
                theModel.addAttribute("errorMessages", errorMessages);
                return "error";
            }
            ExamRegistration examRegistration = new ExamRegistration();
            examRegistration.setStudent(student);
            examRegistration.setExam(exam);
            examRegistrationService.save(examRegistration);
        }
        return "redirect:/exam_period/list";
    }

    @PostMapping("/save")
    public String SaveExamRegistration(@ModelAttribute("examRegistration") ExamRegistration theExamRegistration,
                                       Model theModel) {
        List<String> errorMessages = examRegistrationService.examValidation(
                theExamRegistration.getStudent(), theExamRegistration.getExam());
        if (!errorMessages.isEmpty()) {
            theModel.addAttribute("errorMessages", errorMessages);
            return "error";
        }
        examRegistrationService.save(theExamRegistration);
        return "redirect:/exam_period/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("examRegId") Long id) {
        System.out.println(id);
        examRegistrationService.deleteById(id);
        System.out.println("exam registration deleted");
        return "redirect:/exam_period/list";
    }

    void examRegistrationAttributes(int id, Model model) {
        ExamPeriod theExamPeriod = examPeriodService.findById(id);
        List<Student> theStudents = studentService.findAll();
        List<Exam> theExams = examService.findAllExamsInExamPeriod(theExamPeriod);
        model.addAttribute("examPeriod", theExamPeriod);
        model.addAttribute("studentsList", theStudents);
        model.addAttribute("examList", theExams);
    }

}
