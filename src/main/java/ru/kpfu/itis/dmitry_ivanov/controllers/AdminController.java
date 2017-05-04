package ru.kpfu.itis.dmitry_ivanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.dmitry_ivanov.model.*;
import ru.kpfu.itis.dmitry_ivanov.services.*;

/**
 * Created by Dmitry on 04.05.2017.
 */

@Controller
public class AdminController {

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

    @RequestMapping("/admin/addnew")
    public String addNew(Model model){
        addUsername(model);
        return "addnew";
    }

    @RequestMapping(value = "/admin/addnew", method = RequestMethod.POST)
    public String postSchedule(Model model,
                                @RequestParam("city") String city,
                               @RequestParam("university") String university,
                               @RequestParam("faculty") String faculty,
                               @RequestParam("professor") String professorName,
                               @RequestParam("professorTheme") String professorTheme,
                               @RequestParam("professorAge") String age,
                               @RequestParam("professorExp") String exp,
                               @RequestParam("professorRegalia") String reg){
        addUsername(model);
        City city1= new City();
        city1.setCityName(city);
        cityService.addCity(city1);
        University university1 = new University();
        university1.setCity(cityService.getOneByName(city));
        university1.setUniversityName(university);
        universityService.addUniversity(university1);
        Faculty faculty1 = new Faculty();
        faculty1.setName(faculty);
        faculty1.setUniversity(universityService.findByUniversityName(university));
        facultyService.addFaculty(faculty1);
        Professor professor = new Professor();
        professor.setUniversity(universityService.findByUniversityName(university));
        professor.setAge(Integer.parseInt(age));
        professor.setExperience(Integer.parseInt(exp));
        professor.setFaculty(facultyService.findByFacultyName(faculty));
        professor.setFio(professorName);
        professor.setTheme(professorTheme);
        professor.setRegalia(reg);
        professorService.addProfessor(professor);
        Long id = professorService.findProfessorByFio(professorName).getId();
        return "redirect:/search/timetable?id="+id;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String edit(Model model, @RequestParam("id") String id,
                       @RequestParam("day") String day,
                       @RequestParam("time") String time,
                       @RequestParam("aud") String aud,
                       @RequestParam("theme") String theme){
        addUsername(model);
        Schedule schedule = new Schedule();
        schedule.setProfessor(professorService.findProfessorById(Long.valueOf(id)));
        schedule.setAud(Integer.parseInt(aud));
        schedule.setTheme(theme);
        schedule.setDay(Integer.parseInt(day));
        schedule.setTime(Integer.parseInt(time));
        scheduleService.addSchedule(schedule);
        return "redirect:/search/timetable?id="+id;
    }

    @RequestMapping(value = "/admin/edit")
    public String editPage(Model model, @RequestParam("id") String id){
        addUsername(model);
        return "edit";
    }

    private void addUsername(Model model){
        org.springframework.security.core.userdetails.User userDetail = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userdet",userDetail);
    }
}
