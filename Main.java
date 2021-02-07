package com.gmail.oastro36;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static Student[] creatStudentsArray(Group gr, String num) {
		Student stOne = new Student("Qwe" + num, "Wer" + num, "Ert" + num, 18, true, gr.getGroupName(), 2);
		Student stTwo = new Student("Rty" + num, "Tyu" + num, "Yui" + num, 19, true, gr.getGroupName(), 3);
		Student stThree = new Student("Uio" + num, "Iop" + num, "Asd" + num, 17, false, gr.getGroupName(), 7);
		Student stFour = new Student("Sdf" + num, "Dfg" + num, "Fgh" + num, 17, true, gr.getGroupName(), 1);
		Student stFive = new Student("Ghj" + num, "Hjk" + num, "Jkl" + num, 20, false, gr.getGroupName(), 8);
		Student stSix = new Student("Zxc" + num, "Xcv" + num, "Cvb" + num, 18, true, gr.getGroupName(), 6);
		Student stSeven = new Student("Vbn" + num, "Bnm" + num, "Ewq" + num, 19, true, gr.getGroupName(), 10);
		Student stEight = new Student("Rew" + num, "Tre" + num, "Ytr" + num, 20, true, gr.getGroupName(), 4);
		Student stNine = new Student("Uyt" + num, "Iuy" + num, "Oiu" + num, 17, false, gr.getGroupName(), 9);
		Student stTen = new Student("Poi" + num, "Dsa" + num, "Fds" + num, 18, true, gr.getGroupName(), 5);
		Student[] studentsArray = new Student[] { stOne, stTwo, stThree, stFour, stFive, stSix, stSeven, stEight,
				stNine, stTen };
		return studentsArray;
	}

	public static void main(String[] args) {
		Faculty faculty = new Faculty("Programming", 3);

		Group grOne = new Group("ST-91");
		Student[] studentsArray = creatStudentsArray(grOne, "one");
		fillingArray(studentsArray, grOne);

		Group grTwo = new Group("ST-92");
		studentsArray = creatStudentsArray(grTwo, "two");
		fillingArray(studentsArray, grTwo);

		Group grThree = new Group("ST-93");
		studentsArray = creatStudentsArray(grThree, "three");
		fillingArray(studentsArray, grThree);

		faculty.addGroup(grOne);
		faculty.addGroup(grTwo);
		faculty.addGroup(grThree);

//		System.out.println(faculty);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("faculty.txt"))) {
			oos.writeObject(faculty);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Faculty facultyFromFile = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("faculty.txt"))) {
			facultyFromFile = (Faculty) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Faculty from file: " + facultyFromFile.toString());
	}

	public static void fillingArray(Student[] array, Group g) {
		for (Student student : array) {
			try {
				g.addStudent(student);
			} catch (EleventhStudentExeption e) {
				System.out.println(e.getMessage());
			}
		}
	}
}