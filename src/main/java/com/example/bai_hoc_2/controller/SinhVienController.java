package com.example.bai_hoc_2.controller;

import com.example.bai_hoc_2.entity.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class SinhVienController {
    @RequestMapping("/student")
    public String index(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File path = ResourceUtils.getFile("D:\\JAVA_FPOLY_TUANNQPH20022\\LAP_TRINH_JAVA_6\\BAI_HOC\\BAI_HOC_2\\src\\main\\resources\\static\\students.json");
        TypeReference<List<Students>> typeref = new TypeReference<>() {
        };
        List<Students> students = mapper.readValue(path, typeref);
        int i = index.orElse(0);
        model.addAttribute("n", i);
        model.addAttribute("sv", students.get(i));
        return "scope/student";
    }
}
