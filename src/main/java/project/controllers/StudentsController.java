package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.StudentDAO;
import project.models.Student;

import javax.validation.Valid;


@Controller
@RequestMapping("/students")
public class StudentsController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentsController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //получим всех людей из дао
        model.addAttribute("students", studentDAO.index());
        return "students/index";
    }

    @GetMapping("/{uni_id}")
    public String show(@PathVariable("uni_id") int uni_id, Model model) {
        //получаем одного человека по его айди из дао и передадим на отображение в представление
        model.addAttribute("student", studentDAO.show(uni_id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student")Student student){
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "students/new";

        studentDAO.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{uni_id}/edit")
    public String edit(Model model, @PathVariable("uni_id") int uni_id){
        model.addAttribute("student", studentDAO.show(uni_id));
        return "students/edit";
    }

    @PatchMapping("/{uni_id}")
    public String update(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult, @PathVariable("uni_id") int uni_id){
        if(bindingResult.hasErrors())
            return "students/edit";

        studentDAO.update(uni_id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{uni_id}")
    public String delete(@PathVariable("uni_id") int uni_id){
        studentDAO.delete(uni_id);
        return "redirect:/students";
    }

}
