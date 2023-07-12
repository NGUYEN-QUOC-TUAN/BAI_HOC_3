package com.example.bai_hoc_2.controller;

import com.example.bai_hoc_2.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping("/home/index")
    public String view(Model model) throws IOException {
        model.addAttribute("message", "Welcome to thymleaf");
        ObjectMapper mapper = new ObjectMapper();
        String path = "D:\\JAVA_FPOLY_TUANNQPH20022\\LAP_TRINH_JAVA_6\\BAI_HOC\\BAI_HOC_2\\src\\main\\resources\\static\\student.json";
        Student student = mapper.readValue(new File(path), Student.class);
        model.addAttribute("sinhvien", student);
        return "/home/index";
    }
}
