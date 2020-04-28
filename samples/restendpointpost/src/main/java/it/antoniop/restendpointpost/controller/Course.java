package it.antoniop.restendpointpost.controller;

/**
 *  Created by Antonio:P on 02/03/20.
 */
public class Course {

    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
		this.credits = credits;
    }

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
}
