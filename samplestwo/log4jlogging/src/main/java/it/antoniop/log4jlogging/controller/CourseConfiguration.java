package it.antoniop.log4jlogging.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
@ConfigurationProperties("course")
public class CourseConfiguration {

    private String name;

    private int credits;

    private int year;

    private String professor;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getCredits() {
		return credits;
	}
    
    public void setCredits(int credits) {
		this.credits = credits;
	}

    public int getYear() {
        return year;
    }

    public void setYear(int rating) {
        this.year = rating;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String aProf) {
        this.professor = aProf;
    }
}
