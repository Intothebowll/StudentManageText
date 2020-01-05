package model;

public class Student {
	int num;
	String sname;
	String sex;
	int age;
	String dept;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Student(int num, String sname, String sex, int age,String dept)
			 {
		super();
		this.num = num;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.dept = dept;
	}
}
