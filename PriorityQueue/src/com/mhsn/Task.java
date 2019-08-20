package com.mhsn;

public class Task {

	String job;
	int priority;
	
	public Task(String job, int priority) {
		super();
		this.job = job;
		this.priority = priority;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
		
}
