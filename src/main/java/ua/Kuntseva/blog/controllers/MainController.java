package ua.Kuntseva.blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.Kuntseva.blog.models.Users;
import ua.Kuntseva.blog.repo.UsersRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/home") //обработка главной страницы
    public String home(Model model) {
        model.addAttribute("title","Main page");
        return "home";
    }

    @GetMapping("/")
    public String loginProcess(Model model) {
        return "loginPage";
    }

    @PostMapping("/")
    public String loginProcessing(@RequestParam String login,
                                  @RequestParam String password,
                                  Model model) {
        String returnPage = "loginPage"; // or home
        String message;
        boolean current = false;
        Users currentUser = new Users(login, password);
       Iterable <Users> users = usersRepository.findAll();
        Iterator<Users> iter = users.iterator();
       // Users registeredUser = new Users();
        List<Users> registeredUsers = new ArrayList();
        while (iter.hasNext()) {
            registeredUsers.add(iter.next());
        };
        for (Users user : registeredUsers) {
            if ( (user.getLogin()).equals(currentUser.getLogin())
                && (user.getPassword()).equals(currentUser.getPassword()) ) {
                current = true;
            }
        }

        if (current) {
                returnPage = "redirect:/home";
                logger.info("this is registered user");
            }
            else { message = "Not registered User. Try again";
                model.addAttribute("message", message);
                logger.info("this is not registered user");
            }
        return returnPage;
    }


    @GetMapping("/about")
    public String aboutMethod(Model model) {
        model.addAttribute("title","About me page");
        return "about";
    }

}
