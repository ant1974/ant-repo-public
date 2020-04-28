package it.antoniop.restendpointget.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 *  Created by Antonio:P on 02/03/20.
 */
@RestController
public class RestEnpoints {


    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Biology", required = false) String name,
            				  @RequestParam(value = "credits", defaultValue = "2", required = false) int credits) {
    	return new Course(name, credits);
    }
}
