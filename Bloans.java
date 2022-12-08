package Pack1;

public class Bloans {
	void menu()  {
		
	}
	double balance(double[] loans, int user)  {
		return loans[user];
	}
	double pay(double[] loans, int user, double amount)  {
		if(amount > loans[user])  {
			return -1;
		}
		return loans[user] - amount;
	}
}
