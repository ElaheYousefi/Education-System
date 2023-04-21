package ir.ac.qiau.iau.educational.controller;

import ir.ac.qiau.iau.educational.model.*;
import ir.ac.qiau.iau.educational.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/poll")
public class PollingController {

    private TeacherService teacherService;
    private PollingService pollingService;
    private LectureService lectureService;
    private StudentService studentService;

    @Autowired
    PollingController(TeacherService teacherService, PollingService pollingService,
                      LectureService lectureService, StudentService studentService){
        this.teacherService= teacherService;
        this.pollingService= pollingService;
        this.lectureService= lectureService;
        this.studentService= studentService;
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String programPage(Model model){
        Polling polling= new Polling();
        PollingKey key= new PollingKey();
        key.setStudentId(9114562344l);
        key.setTeacherId(345);
        key.setLectureId(4567);
        polling.setId(key);
        model.addAttribute("polling", polling);
        return "student/Polling";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Polling polling){
        Student student= studentService.findById(polling.getId().getStudentId());
        Teacher teacher= teacherService.getTeacherById(polling.getId().getTeacherId());
        Lecture lecture= lectureService.getLectureById(polling.getId().getLectureId());
        polling.setLecture(lecture);
        polling.setTeacher(teacher);
        polling.setStudent(student);
        pollingService.savePolling(polling);
        return "student/Polling";
    }
}
