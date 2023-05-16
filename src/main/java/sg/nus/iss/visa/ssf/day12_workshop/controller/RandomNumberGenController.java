package sg.nus.iss.visa.ssf.day12_workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //not using RestController cos we don't need json, we want html
@RequestMapping(path = "/api")
public class RandomNumberGenController {
    
    @GetMapping("/home")
    public String landingPage(){
        return "home";
    }

}
