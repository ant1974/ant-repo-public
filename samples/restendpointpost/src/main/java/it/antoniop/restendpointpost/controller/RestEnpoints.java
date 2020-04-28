package it.antoniop.restendpointpost.controller;

import org.springframework.web.bind.annotation.*;


/**
 *  Created by Antonio:P on 02/03/20.
 */

@RestController
public class RestEnpoints {


	// no "method" attribute  means  =>  defaulting to GET
	@RequestMapping("/course")
	public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Biology", required = false) String name,
			@RequestParam(value = "credits", defaultValue = "2", required = false) int credits) {
		return new Course(name, credits);
	}    
    

    
    // Here path == value 
    @RequestMapping(method = RequestMethod.POST, path = "/register/course")
    public String saveCourse(@RequestBody Course course){
        return "Your course named "+ course.getName() + " valued " + course.getCredits() + " credits has been saved successfuly.";
    }


}
