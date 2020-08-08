package com.example.student.controller;

import com.example.student.persistent.entities.Student;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getStudentsList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String removeStudent(@PathVariable String id) {
        studentService.removeStudent(id);
        return "redirect:/students";
    }
}
