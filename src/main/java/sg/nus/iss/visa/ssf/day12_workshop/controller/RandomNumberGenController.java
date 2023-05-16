package sg.nus.iss.visa.ssf.day12_workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.nus.iss.visa.ssf.day12_workshop.model.Image;
import sg.nus.iss.visa.ssf.day12_workshop.service.RandomNumberService;


@Controller //not using RestController cos we don't need json, we want html
@RequestMapping(path = "/api")
public class RandomNumberGenController {
    
    //injecting service class dependency
    @Autowired
    RandomNumberService service;

    @GetMapping("/home")
    public String landingPage(){
        return "home";
    }

    @GetMapping("/get")
    public String generateRanNumbers(Model model, HttpServletRequest request){
        
        //fetch input param
        int number = Integer.parseInt(request.getParameter("number"));
        System.out.println("input no is :"+ number);

        //check condition if no is between 0 -30
        if (number<1 || number >30){
            String errorMessage = "Invalid Number "+ number;
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }

        //calling service method (RandomNumberService's method)
        List<Integer> randomNumbers = service.generateRandomNumbers(number);

        //populate image objects
        List<Image> imageList = new ArrayList<Image>();

        for (int randomNumber: randomNumbers){
            imageList.add(new Image(Integer.toString(randomNumber),"/images/" + Integer.toString(randomNumber) +".png"));
        }
        
        model.addAttribute(imageList);

        return "display";
    }

}
