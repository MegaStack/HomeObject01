package com.gmail.oastro36;

import java.io.Serializable;
import java.util.Arrays;

public class Faculty implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nameFaculty;
	private int countGroups;
	private Group[] faculty;

	public Faculty(String nameFaculty, int countGroups) {
		super();
		this.nameFaculty = nameFaculty;
		this.countGroups = countGroups;
		this.faculty = new Group[countGroups];
	}

	public Faculty() {
		super();
	}

	public void addGroup(Group gr) {
		for (int i = 0; i < faculty.length; i++) {
			if (faculty[i] == null) {
				faculty[i] = gr;
				break;
			}
		}
	}

	public String getNameFaculty() {
		return nameFaculty;
	}

	public void setNameFaculty(String nameFaculty) {
		this.nameFaculty = nameFaculty;
	}

	public Group[] getFaculty() {
		return faculty;
	}

	public void setFaculty(Group[] faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Faculty = " + nameFaculty + System.lineSeparator());
		sb.append(System.lineSeparator());
		for (int i = 0; i < faculty.length; i++) {
			sb.append(faculty[i].toString());
		}
		return sb.toString();
	}
}
