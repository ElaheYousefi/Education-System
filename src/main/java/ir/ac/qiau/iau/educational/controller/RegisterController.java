package ir.ac.qiau.iau.educational.controller;

import ir.ac.qiau.iau.educational.model.*;
import ir.ac.qiau.iau.educational.service.LectureService;
import ir.ac.qiau.iau.educational.service.RegistrationService;
import ir.ac.qiau.iau.educational.service.StudentService;
import ir.ac.qiau.iau.educational.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    StudentService studentService;
    @Autowired
    LectureService lectureService;
    @Autowired
    RegistrationService regService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String selectStudent(Model model){

        List<Student> students= studentService.getStudents();
        model.addAttribute("students", students);
        List<Lecture> lectures= new ArrayList<>();
        model.addAttribute("availLectures", lectures);
        model.addAttribute("gottenLectures", lectures);
        return "/student/Registration";
    }

    @RequestMapping(value= "/showLecture", params="selectStd")
    public String showLectures(@Valid long stdCode, Model model){

        List<Student> students= studentService.getStudents();
        model.addAttribute("students", students);
        //getAvailableLecture
        model.addAttribute("availLectures", lectureService.getAvailableLecures(stdCode));
        //getGottenLecture
        model.addAttribute("gottenLectures", lectureService.getGottenLectures(stdCode));
        model.addAttribute("studentCode", stdCode);
        return "/student/Registration";
    }

    @RequestMapping(value="/showLecture", params="showGroups")
    public String showGroups(@Valid long lectureId, Model model, @Valid long studCode){

        List<Lecture> groups= lectureService.getGroupsForLecture(lectureId);
        model.addAttribute("groups", groups);
        model.addAttribute("studentCode", studCode);
        return "/student/LectureGroup";
    }

    @RequestMapping(value="/doRegister")
    public String doRegister(@Valid long teacherId, @Valid int lectId, @Valid long studCode, Model model){

        Registration registration= new Registration();
        registration.setLecture(lectureService.getLectureById(lectId));
        registration.setTeacher(teacherService.getTeacherById(teacherId));
        registration.setStudent(studentService.findById(studCode));
        PollingKey pollingKey= new PollingKey();
        pollingKey.setStudentId(studCode);
        pollingKey.setTeacherId(teacherId);
        pollingKey.setLectureId(lectId);
        registration.setId(pollingKey);
        regService.saveRegistration(registration);
        model.addAttribute("availLectures", lectureService.getAvailableLecures(studCode));
        //getGottenLecture
        model.addAttribute("gottenLectures", lectureService.getGottenLectures(studCode));
        model.addAttribute("studentCode", studCode);
        return "/student/Registration";
    }
    /////////////////////////////////////////
    @RequestMapping(value="/programPage")
    public String showProgramPage(Model model){
        System.out.println("program page");
        List<Student> students= studentService.getStudents();
        model.addAttribute("students", students);
        model.addAttribute("registration", new Registration());
        List<Registration> registrations= new ArrayList<>();
        model.addAttribute("registrations", registrations);
        return "student/Program";
    }

    @RequestMapping(value="/getProgram", params = "program", method = RequestMethod.POST)
    public String getProgramForStd(@ModelAttribute Registration registration, Model model){
        List<Student> students= studentService.getStudents();
        model.addAttribute("students", students);
        List<Registration> registrations= regService.findById(registration.getId().getStudentId());
        model.addAttribute("registrations", registrations);
        model.addAttribute("poll", new Polling());
        return "student/Program";
    }

    @RequestMapping(value="/getProgram", params = "polling", method = RequestMethod.POST)
    public String goPollPage(@ModelAttribute Registration registration, Model model){

        Polling polling= new Polling();
        PollingKey key= new PollingKey();
        key.setStudentId(registration.getId().getStudentId());
        key.setTeacherId(registration.getId().getTeacherId());
        key.setLectureId(registration.getId().getLectureId());
        polling.setId(key);
        model.addAttribute("polling", polling);

        return "student/Polling";
    }
}
