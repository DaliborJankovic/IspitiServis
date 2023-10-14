package DaliborJankovic.StudentskiServis.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class ServisController {

    @GetMapping("/log_in")
    public  String loginPage(Model model) {

        return "loginpage";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return "homepage";
    }

    @PostMapping("/test")
    public String loginLogic(Model model) {
        if(Objects.equals(model.getAttribute("username"), "dal") && Objects.equals(model.getAttribute("password"), "123")){
            return "homepage";
        }
        return "loginpage";
    }

}
