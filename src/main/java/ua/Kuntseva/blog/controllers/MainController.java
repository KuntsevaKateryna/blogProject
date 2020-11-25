package ua.Kuntseva.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/") //обработка главной страницы
    public String home(Model model) {
        //write "Main page" into title variable
        //model.addAttribute("title", "Main page");
        model.addAttribute("title","Main page");
        return "home";
    }

    @GetMapping("/about")
    public String aboutMethod(Model model) {
        model.addAttribute("title","About me page");
        return "about";
    }

}
