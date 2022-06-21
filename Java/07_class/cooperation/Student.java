package f.cooperation;

public class Student {
	String studentName;
	int grade;
	int money;
	
	Student(String studentName){
		this(studentName, 3, 10000);
		/*
		this.studentName = studentName;
		this.money = 10000;
		this.grade = 3;
		*/
	}
	
	Student(String studentName, int money){
		this(studentName,3,money);
		/*
		this.studentName = studentName;
		this.money = money;
		this.grade =3;
		*/
	}
	
	Student(String studentName, int grade,int money){
		this.studentName = studentName;
		this.money = money;
		this.grade = grade;
	}
	
	void takeBus(Bus bus) {
		int pay = getPay();
		bus.take(pay);
		this.money -= pay;
	}
	
	void takeSubway(Subway subway) {
		int pay = getPay();
		subway.take(pay);
		this.money -= pay;
	}
	
	int getPay() {
		int pay = 0;
		switch(grade) {
			case 1 : pay = 600; break;
			case 2 : pay = 800; break;
			case 3 : pay = 1000; break;
		}
		return pay;
	}
	void showInfo() {
		System.out.println(studentName+"님의 남은 돈은"+money+"입니다.");
	}
}