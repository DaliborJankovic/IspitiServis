package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamPeriodRepository;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.enums.ExamPeriodStatus;
import DaliborJankovic.StudentskiServis.service.ExamPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamPeriodServiceImpl implements ExamPeriodService {

    private final ExamPeriodRepository examPeriodRepository;

    @Override
    public void save(ExamPeriod examPeriod) {
        examPeriodRepository.save(examPeriod);
    }

    @Override
    public ExamPeriod findById(Integer id) {
        Optional<ExamPeriod> result = examPeriodRepository.findById(id);
        ExamPeriod tempExamPeriod = null;
        if (result.isPresent()) {
            tempExamPeriod = result.get();
        } else {
            throw new RuntimeException("No results for Exam Period");
        }

        return tempExamPeriod;
    }

    @Override
    public List<ExamPeriod> findAll() {
        return examPeriodRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        examPeriodRepository.deleteById(id);
    }

    @Override
    public void isActive(List<ExamPeriod> examPeriodList, Model model) {
        List<ExamPeriod> activeExamPeriodList = new ArrayList<>();
        List<ExamPeriod> upcomingExamPeriodList = new ArrayList<>();
        for (ExamPeriod ep : examPeriodList) {
            if (ep.getStatus().equals(ExamPeriodStatus.ACTIVE)) {
                activeExamPeriodList.add(ep);
            } else {
                upcomingExamPeriodList.add(ep);
            }
        }
        model.addAttribute("active", activeExamPeriodList);
        model.addAttribute("upcoming", upcomingExamPeriodList);
    }

    @Override
    public void validateRegistrationPeriod(List<ExamPeriod> examPeriodList, Model model) {
        List<ExamPeriod> activeRegistrationPeriodList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (ExamPeriod ep : examPeriodList) {
            LocalDate weekBefore = ep.getStartDate().minus(8, ChronoUnit.DAYS);
            if (today.isAfter(weekBefore) &&
                    today.isBefore(ep.getStartDate())) {
                activeRegistrationPeriodList.add(ep);
            }
        }
        model.addAttribute("activeReg", activeRegistrationPeriodList);
    }

    @Override
    public List<String> validateExamPeriod(List<ExamPeriod> examPeriodList, ExamPeriod currentExamPeriod) {
        List<String> errorMessages = new ArrayList<>();
        if (currentExamPeriod.getEndDate().isBefore(currentExamPeriod.getStartDate())) {
            errorMessages.add("The exam period End date can't be before the Start date.");
        }
        for (ExamPeriod epDate : examPeriodList) {
            if ((currentExamPeriod.getStartDate().isBefore(epDate.getEndDate()) ||
                    currentExamPeriod.getStartDate().isEqual(epDate.getEndDate())) &&
                    (currentExamPeriod.getEndDate().isEqual(epDate.getStartDate()) ||
                            currentExamPeriod.getEndDate().isAfter(epDate.getStartDate()))) {
                // proverava da li se rokovi preklapaju
                errorMessages.add("The exam period overlaps with an existing one.");
            }
        }
        if (currentExamPeriod.getStatus().equals(ExamPeriodStatus.ACTIVE)) {
            for (ExamPeriod epStatus : examPeriodList) {
                if (epStatus.getStatus().equals(ExamPeriodStatus.ACTIVE)) {
                    // proverava da li postoji aktivan ispitni rok
                    errorMessages.add("There is already an active exam period.");
                }
            }
        }
        return errorMessages;
    }
}
