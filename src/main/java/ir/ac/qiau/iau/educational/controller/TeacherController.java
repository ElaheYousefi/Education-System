package ir.ac.qiau.iau.educational.controller;

import ir.ac.qiau.iau.educational.model.Teacher;
import ir.ac.qiau.iau.educational.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

//    @RequestMapping(value = "/rest/get", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Teacher> getTeachersRest(){
//        List<Teacher> teachers= teacherService.getTeachers();
//        for(Teacher teacher: teachers){
//            List<Lecture> lectures= teacher.getLectures();
//            for(Lecture lecture: lectures){
//            }
//
//        }
//        return teachers;
//    }
//
//    @RequestMapping(value="/rest/register", method = RequestMethod.POST)
//    public @ResponseBody Teacher registerTeacherRest(@RequestBody Teacher teacher){
//        return teacherService.registerTeacher(teacher);
//    }

    @RequestMapping({"/", ""})
    public String getTeacherModel(Model model){
        model.addAttribute("teachers", teacherService.getTeachers());
        return "teacher/Teacher";
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "teacher/RegisterTeacher";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String save(@ModelAttribute Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teacher";
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") Long id ){
        teacherService.delete(id);
        return "redirect:/teacher";
    }

    @RequestMapping(value="/newTeacher")
    public String newTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacher/RegisterTeacher";
    }
}
