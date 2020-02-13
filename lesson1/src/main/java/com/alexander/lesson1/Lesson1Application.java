package com.alexander.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
@Service
public class Lesson1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson1Application.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/rest")
    @ResponseBody
    public Map<String, Object> rest() {
        Map<String, Object> data = new HashMap<>();

        data.put("1", 'A');
        data.put("2", 2);

        return data;
    }

    @RequestMapping("/index")
    public String index(@RequestParam(defaultValue = "world", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
