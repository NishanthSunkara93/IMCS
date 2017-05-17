package com.javafiles;

import java.util.List;

public class Marks {

	private List<String>  subjectName;
	private List<Integer> marks;
	private List<Integer> maxMarks;
	public Marks(List<String> subjectName, List<Integer> marks, List<Integer> maxMarks) {
		super();
		this.subjectName = subjectName;
		this.marks = marks;
		this.maxMarks = maxMarks;
	}
	public Marks() {
		super();
	}
	public List<String> getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(List<String> subjectName) {
		this.subjectName = subjectName;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public List<Integer> getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(List<Integer> maxMarks) {
		this.maxMarks = maxMarks;
	}
	@Override
	public String toString() {
		return "Marks [subjectName=" + subjectName + ", marks=" + marks + ", maxMarks=" + maxMarks + "]";
	}
	
	 
		
}
