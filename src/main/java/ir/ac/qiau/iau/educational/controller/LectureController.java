package ir.ac.qiau.iau.educational.controller;

import ir.ac.qiau.iau.educational.model.Lecture;
import ir.ac.qiau.iau.educational.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    //--------------------------Rest API------------------------------------
    @RequestMapping(value = "/rest/get", method = RequestMethod.GET)
    public @ResponseBody
    List<Lecture> getLecturesRest(){
        return lectureService.getLectures();
    }

    @RequestMapping(value="/rest/register", method = RequestMethod.POST)
    public @ResponseBody Lecture registerLectureRest(@RequestBody Lecture lecture){
        return lectureService.registerLecture(lecture);
    }
    //---------------------------------------------------------------------
    @RequestMapping({"/", ""})
    public String getLectures(Model model){
        model.addAttribute("lectures", lectureService.getLectures());
        return "lecture/Lecture";
    }

}
