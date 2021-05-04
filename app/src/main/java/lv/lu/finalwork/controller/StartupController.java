package lv.lu.finalwork.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartupController {

    @RequestMapping(value = "/")
    public String SpringBootStarted(){
        return "Hello in Spring Boot";
    }
}
