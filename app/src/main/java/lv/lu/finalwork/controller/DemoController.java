package lv.lu.finalwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }
}
