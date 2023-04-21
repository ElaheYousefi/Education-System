package ir.ac.qiau.iau.educational.controller;

import ir.ac.qiau.iau.educational.model.Student;
import ir.ac.qiau.iau.educational.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //------------------------------Rest API----------------------------
//    @RequestMapping(value = "/rest/get", method = RequestMethod.GET)
//    public @ResponseBody List<Student> getStudentsRest(){
//        return studentService.getStudents();
//    }
//
//    @RequestMapping(value="/rest/register", method = RequestMethod.POST)
//    public @ResponseBody Student registerStudentRest(@RequestBody Student student){
//        return studentService.saveStudent(student);
//    }
    //--------------------------------End-------------------------------

    //------------------------------------------------------------------
    @RequestMapping({"/", ""})
    public String getStudents(Model model){

        model.addAttribute("students", studentService.getStudents());
        return "student/Student";
    }

    @RequestMapping({"/new"})
    public String createStudent(Model model){

        model.addAttribute("student", new Student());
        return "student/RegisterStudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student/RegisterStudent";
        }
        studentService.saveStudent(student);
        return "student/RegisterStudent";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("student", new Student());
        return "student/RegisterStudent";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent(Model model ,@PathVariable("id") Long id) {
        model.addAttribute("student",studentService.findById(id));
        return "student/RegisterStudent";
    }
}
