package t01_create_thread;

public class BeepThreadExample {

	public static void main(String[] args) {
		// 동 시 에 진 행	
		System.out.println("MAIN 시작");
		
		// 첫번째 스레드
		Thread t = new BeepThread();
		t.start(); //새로운 작업 스레드
		
		// 두번째 스레드 : PrintTask class에서 만드는 것
		Runnable run = new PrintTask();
		Thread t1 = new Thread(run);
		t1.start();
		
		// 세번째 스레드                                    
		for(int i=0; i<5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		// 두번째 스레드의 다른 방법 : 익명 구현객체, 클래스가 따로 없어서 블럭안에서만 실행가능
		Runnable workTask = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("t2");
				}
			}
		};
		
		System.out.println("MAIN 종료");
	}
}