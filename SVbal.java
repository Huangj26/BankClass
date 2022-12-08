package Pack1;

public class SVbal {
	public SVbal() {
	}
	void menu()  {
		
	}
	double balance(double[] bals, int user)  {
		return bals[user];
	}
	double withdraw(double[] bals, int user, double with)   {
		if(with <= bals[user])  {
			return bals[user] - with;
		}else  {
			return -1.0;
		}
	}
	double deposit(double[] bals, int user, double depo)  {
		return bals[user] + depo;
	}
}
