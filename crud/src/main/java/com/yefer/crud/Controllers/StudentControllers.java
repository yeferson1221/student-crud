package com.yefer.crud.Controllers;


import com.yefer.crud.entity.Student;
import com.yefer.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentControllers {

    @Autowired
    private StudentService studentService;

    @GetMapping({"/students","/"})
    public  String listStudent(Model model, @Param("keyWord") String keyWord){
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("students", studentService.listStudent(keyWord));
        return "students";  //nos  retorna estudiantes
    }


    @GetMapping("/students/new")
    public String newStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return  "new_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student ){
        studentService.saveStudent(student);
        return  "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.searchStudentForId(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student, Model model){
        Student studentExisting = studentService.searchStudentForId(id);
        studentExisting.setId(id);
        studentExisting.setName(student.getName());
        studentExisting.setLastname(student.getLastname());
        studentExisting.setEmail(student.getEmail());

        studentService.updateStudent(studentExisting);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}
