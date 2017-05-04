package ru.kpfu.itis.dmitry_ivanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.dmitry_ivanov.model.*;
import ru.kpfu.itis.dmitry_ivanov.services.*;

import java.util.*;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Controller
public class SearchController {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private CityService cityService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping({"/", "/home"})
    public String home(Model model) {
        addUsername(model);
        model.addAttribute("cities", cityService.getAllCities());
        return "home";
    }

    @RequestMapping("/search/university")
    public String university(Model model, @RequestParam("id") String id){
        addUsername(model);
        Set<University> universityList = cityService.findById(Long.parseLong(id)).getUniversities();
        model.addAttribute("universities", universityList);
        return "university";
    }

    @RequestMapping("/search/department")
    public String department(Model model, @RequestParam("id") String id){
        addUsername(model);
        Set<Faculty> faculties = universityService.findById(Long.valueOf(id)).getFaculties();
        model.addAttribute("faculties", faculties);
        return "faculties";
    }

    @RequestMapping("/search/professor")
    public String professor(Model model, @RequestParam("id") String id){
        addUsername(model);
        Set<Professor> professors = facultyService.findFacultyById(Long.valueOf(id)).getProfessors();
        model.addAttribute("professors", professors);
        return "professors";
    }

    @RequestMapping("/search/timetable")
    public String timetable(Model model, @RequestParam("id") String id){
        addUsername(model);
        Set<Schedule> schedules = professorService.findProfessorById(Long.valueOf(id)).getSchedules();
        List<Schedule> scheduleListbyDay;
        scheduleListbyDay=getByDay(schedules,1);
        if(scheduleListbyDay.size()>0) {
            for(Schedule schedule: scheduleListbyDay){
                model.addAttribute("monday_"+schedule.getTime(), schedule.getTheme());
            }
        }
        scheduleListbyDay=getByDay(schedules,2);
            if(scheduleListbyDay.size()>0) {
                for(Schedule schedule: scheduleListbyDay){
                    model.addAttribute("tuesday_"+schedule.getTime(), schedule.getTheme());
                }
            }
        scheduleListbyDay=getByDay(schedules,3);
                if(scheduleListbyDay.size()>0) {
                    for(Schedule schedule: scheduleListbyDay){
                        model.addAttribute("wednesday_"+schedule.getTime(), schedule.getTheme());
                    }
                }
        scheduleListbyDay=getByDay(schedules,4);
                    if(scheduleListbyDay.size()>0) {
                        for(Schedule schedule: scheduleListbyDay){
                            model.addAttribute("thursday_"+schedule.getTime(), schedule.getTheme());
                        }
                    }
        scheduleListbyDay=getByDay(schedules,5);
                        if(scheduleListbyDay.size()>0) {
                            for(Schedule schedule: scheduleListbyDay){
                                model.addAttribute("friday_"+schedule.getTime(), schedule.getTheme());
                            }
                        }
        scheduleListbyDay=getByDay(schedules,6);
                            if(scheduleListbyDay.size()>0) {
                                for(Schedule schedule: scheduleListbyDay){
                                    model.addAttribute("saturday_"+schedule.getTime(), schedule.getTheme());
                                }
                            }
        model.addAttribute("prof",professorService.findProfessorById(Long.valueOf(id)));

        return "timetable";
    }

    private void addUsername(Model model){
        org.springframework.security.core.userdetails.User userDetail = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userdet",userDetail);
    }

    private List<Schedule> getByDay(Set<Schedule> schedules, int day){
        List<Schedule> out =  new LinkedList<>();
        for(Schedule schedule: schedules){
            if(schedule.getDay()==day){
                out.add(schedule);
            }
        }
        return out;
    }

}
