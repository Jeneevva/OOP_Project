package project.controllers;

import jdk.internal.module.IllegalAccessLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @GetMapping()
    public String index(Model model) {
        //получим всех людей из дао
        return null;
    }

    @GetMapping("/{uni_id}")
    public String show(@PathVariable("uni_id") int uni_id) {
        //получаем одного человека по его айди из дао и передадим на отображение в представление
        return null;
    }

}
