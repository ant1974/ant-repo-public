package it.antoniop.log4jlogging.controller;


/**
 * 
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [name=");
		builder.append(name);
		builder.append(", credits=");
		builder.append(credits);
		builder.append("]");
		return builder.toString();
	}
    
    
}
