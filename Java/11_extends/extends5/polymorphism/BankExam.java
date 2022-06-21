package extends5.polymorphism;

class Bank{
	double getInterestRate() {
		return 20.0;
	}
}

class BadBank extends Bank{
	@Override
	double getInterestRate() {
		return 10.0;
	}
}

class NormalBank extends Bank{
	@Override
	double getInterestRate() {
		return 5.0;
	}
}

class GoodBank extends Bank{
	@Override
	double getInterestRate() {
		return 2.0;
	}
}

public class BankExam {

	public static void main(String[] args) {
			Bank bank = new Bank();
			System.out.println(bank.getInterestRate());
			Bank BadBank = new BadBank();
			System.out.println(BadBank.getInterestRate());
			Bank NormalBank = new NormalBank();
			System.out.println(NormalBank.getInterestRate());
			Bank GoodBank = new GoodBank();
			System.out.println(GoodBank.getInterestRate());
	}
}
