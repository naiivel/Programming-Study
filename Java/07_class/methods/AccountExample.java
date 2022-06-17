package c.methods;

public class AccountExample {

	public static void main(String[] args) {
		Account naiivel = new Account();
		naiivel.deposit(1000000);
		naiivel.withdraw(10000000);
		
		Account ryiubry = new Account();
		ryiubry.deposit(1000);
		ryiubry.withdraw(1000000);
		ryiubry.deposit(-20000);
		
		System.out.println("naiivel balance: " + naiivel.balance);
		System.out.println("ryiubry balance :" + ryiubry.balance);
	}

}
