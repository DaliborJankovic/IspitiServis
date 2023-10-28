package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import DaliborJankovic.StudentskiServis.service.CityService;
import DaliborJankovic.StudentskiServis.service.ProfessorService;
import DaliborJankovic.StudentskiServis.service.TitleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    private ProfessorService professorService;
    private CityService cityService;
    private TitleService titleService;

    public ProfessorController(ProfessorService professorService, CityService cityService, TitleService titleService) {
        this.professorService = professorService;
        this.cityService = cityService;
        this.titleService = titleService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Professor> theProfessorList = professorService.findAll();
        model.addAttribute("professorList", theProfessorList);
        return "/professors/professor-form";
    }

    @GetMapping("{professorId}")
    public String viewProfessor(@PathVariable String professorId, Model theModel) {
        Professor theProfessor = professorService.findById(professorId);
        theModel.addAttribute("professor", theProfessor);
        return "professors/details";
    }

    @GetMapping("/add")
    public String addProfessor(Model theModel) {
        Professor theProfessor = new Professor();
        List<City> cities = cityService.findAll();
        List<Title> titles = titleService.findAll();
        theModel.addAttribute("professor", theProfessor);
        theModel.addAttribute("cityList", cities);
        theModel.addAttribute("titlesList", titles);
        return "professors/add-professor-form";
    }

    @GetMapping("/update/{professorId}")
    public String updateProfessor(@PathVariable String professorId, Model theModel) {
        Professor theProfessor = professorService.findById(professorId);
        List<City> cities = cityService.findAll();
        List<Title> titles = titleService.findAll();
        theModel.addAttribute("professor", theProfessor);
        theModel.addAttribute("cityList", cities);
        theModel.addAttribute("titlesList", titles);
        return "professors/add-professor-form";
    }

    @PostMapping("/save")
    public String saveProfessor(@ModelAttribute("professor") @Valid Professor theProfessor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "professors/add-professor-form";
        }
        professorService.save(theProfessor);
        return "redirect:/professors/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("professorId") String id) {
        professorService.deleteById(id);
        return "redirect:/professors/list";
    }
}
