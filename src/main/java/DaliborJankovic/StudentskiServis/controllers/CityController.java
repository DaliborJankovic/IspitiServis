package DaliborJankovic.StudentskiServis.controllers;

import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;


    @GetMapping("/list")
    public String citiesList(Model model) {
        List<City> theCityList = cityService.findAll();
        theCityList.sort(Comparator.comparing(City::getCityName));
        model.addAttribute("cityList", theCityList);
        return "/cities/city-form";
    }

    @GetMapping("/add")
    public String addCity(Model theModel) {
        City theCity = new City();
        theModel.addAttribute("city", theCity);
        return "/cities/add-city-form";
    }

    @GetMapping("/add_from_student")

    public String addCityFromStudent(@RequestParam(name = "StudentId", required = false) String StudentId,
                                     Model theModel) {
        City theCity = new City();
        if (!StudentId.isEmpty()) {
            theModel.addAttribute("userId", StudentId);
        }
        theModel.addAttribute("city", theCity);
        theModel.addAttribute("returnTo", "add_from_student");
        return "/cities/add-city-form";
    }

    @GetMapping("/add_from_professor")
    public String addCityFromProfessor(@RequestParam(name = "ProfessorId", required = false) String ProfessorId,
                                       Model theModel) {
        City theCity = new City();
        if (!ProfessorId.isEmpty()) {
            theModel.addAttribute("userId", ProfessorId);
        }
        theModel.addAttribute("city", theCity);
        theModel.addAttribute("returnTo", "add_from_professor");
        return "/cities/add-city-form";
    }

    @PostMapping("/save")
    public String saveCity(@ModelAttribute("city") City theCity,
                           @RequestParam(name = "redirect") String redirect,
                           @RequestParam(name = "id", required = false) String setId) {
        cityService.save(theCity);
        if ("add_from_student".equals(redirect)) {
            if (!setId.isEmpty()) {
                return "redirect:/students/update/" + setId;
            }
            return "redirect:/students/add";
        } else if ("add_from_professor".equals(redirect)) {
            if (!setId.isEmpty()) {
                return "redirect:/professors/update/" + setId;
            }
            return "redirect:/professors/add";
        }
        return "redirect:/cities/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("cityId") int id) {
        cityService.deleteById(id);
        return "redirect:/cities/list";
    }

}

