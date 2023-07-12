package com.example.bai_hoc_2.controller;

import com.example.bai_hoc_2.entity.Student;
import com.example.bai_hoc_2.entity.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class Student2Controller {
    @RequestMapping("/student/list")
    public String view(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
        File file = new ClassPathResource("/static/student.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> type = new TypeReference<>() {
        };
        List<Student> listStudents = mapper.readValue(file, type);
        model.addAttribute("sv", listStudents.get(index.orElse(0)));
        model.addAttribute("listStudents", listStudents);
        return "student/student";
    }
}
