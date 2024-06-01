package Hackathon.Chuck_Je.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "login"; //변경 소요
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; //변경 소요
    }
}
