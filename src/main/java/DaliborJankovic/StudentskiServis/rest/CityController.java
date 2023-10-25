package DaliborJankovic.StudentskiServis.rest;

import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

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

    @PostMapping("/save")
    public String saveCity(@ModelAttribute("city") City theCity, Model model) {
        cityService.save(theCity);
        return "/cities/city-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("cityId") int id) {
        cityService.deleteById(id);
        return "redirect:/cities/list";
    }

}

