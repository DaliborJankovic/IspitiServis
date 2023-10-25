package DaliborJankovic.StudentskiServis.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceController {

    @GetMapping("/log_in")
    public String loginPage(Model model) {
        return "login_page";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return "homepage";
    }

    @PostMapping("/authentication")
    public String loginLogic(@RequestParam("username") String user, @RequestParam("password") String pass, Model model) {
        if ("Dalibor".equals(user) && "111".equals(pass)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password. Please try again.");
            return "login_page";
        }
    }
}
