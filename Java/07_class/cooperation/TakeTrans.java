package f.cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Student studentHan = new Student("한지현",8000);
		Student studentPark = new Student("박정대",2,20000);
		
		Bus bus100 = new Bus(100);
		Bus bus200 = new Bus(200);
		studentHan.takeBus(bus100);
		bus100.showInfo();
		
		Subway subwayGreen = new Subway("2호선");
		studentPark.takeSubway(subwayGreen);
		subwayGreen.showInfo();
		studentPark.showInfo();
		
		Worker workerChoi = new Worker("최기근",2100000);
		workerChoi.takeVehicle(bus100);
		workerChoi.showInfo();
		bus100.showInfo();
	}
}