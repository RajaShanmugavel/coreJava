package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BooleanSort {

	public static void main(String[] args) {
		Student s1 = new Student("Raja", 10051, false);
		Student s2 = new Student("Veni", 12608, true);
		Student s3 = new Student("Mrithi", 10124, false);
		Student s4 = new Student("Harshi", 10034, true);
		Student s5 = new Student("Sowmi", 10002, false);

		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		Collections.sort(list, new BooleanComparator());
		
		list.forEach(s->{
			System.out.println(s);
		});

	}

}

class BooleanComparator implements Comparator<Student>{

/*	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getId() > o2.getId()){
			return 1;
		}else if(o1.getId() < o2.getId()){
			return -1;
		}else{
			return 0;
		}
		
	}*/
	
	@Override
	public int compare(Student o1, Student o2) {
		return Boolean.valueOf(o2.isEligible()).compareTo(o1.isEligible());
	}
	
}

class Student {
	private String name;
	private int id;
	private boolean isEligible;

	public Student(String name, int id, boolean isEligible) {
		super();
		this.name = name;
		this.id = id;
		this.isEligible = isEligible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", isEligible=" + isEligible + "]";
	}

}
