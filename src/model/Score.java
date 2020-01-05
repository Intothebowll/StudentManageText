package model;

public class Score {
	int num;
	String sex;
	String sname;
	String course;
	int score;
	int credit;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public Score(int num, String sname, String course, int score,int credit)
	 {
      super();
      this.num = num;
      this.sex = sex;
      this.sname = sname;
      this.course = course;
      this.score = score;
      this.credit = credit;
      
}
}
