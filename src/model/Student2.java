package model;

public class Student2 {
	String myclass;
	int num;
	String sname;
	String sex;
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
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
	
	public Student2(String myclass,int num, String sname, String sex){
		super();
		this.myclass = myclass;
		this.num = num;
		this.sname = sname;
		this.sex = sex;
	}
}
