package it.antoniop.logbacklogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 
 */

@RestController
public class RestEnpoints {

	
    @Value("${default.course.name}")
    private String cName;

    @Value("${default.course.credits}")
    private int credits;

    // Reading  config data from "application.properties"
    @Autowired
    private CourseConfiguration courseConfiguration;


    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "Calculus", required = false) String name,
                                   @RequestParam(value = "credits", defaultValue = "38", required = false) int credits) {
		return new Course((name == null ? cName : name), credits);
    }

    @RequestMapping("/gethierarchical")
    public HashMap<String,Object> getConfigAnnotateProperties() {

        HashMap<String,Object> map= new HashMap<String,Object>();

        map.put("name",courseConfiguration.getName());
        map.put("credits",courseConfiguration.getCredits());
        map.put("year",courseConfiguration.getYear());
        map.put("professor",courseConfiguration.getProfessor());

        return map;
    }

    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Calculus", required = false) String name,
                              @RequestParam(value = "credits", defaultValue = "38", required = false) int credits) {
        return new Course(name, credits);
    }

    /**
     * 
     * POST raw json data in post body 
     * 
     * 		{ "name": "SignalsTheory", "credits": 55 }
     * 
     * 
     * @param course
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course) {
        return "Your course named "+ course.getName() + " with " + course.getCredits() + " credits saved successfuly.";
    }


}
