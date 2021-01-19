package ua.Kuntseva.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.Kuntseva.blog.models.Users;

@RestController
public class RestControllerTest {

    @RequestMapping("/users")
    public Users userInfo() {
        Users user1 = new Users();
        user1.setLogin("Bogdan");
        user1.setPassword("123");
        return user1;
    }
}
