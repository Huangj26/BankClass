package Pack1;

//password

public class ckPW 

{

	public ckPW() 

	{

	}

	public boolean ckMypw(double[]pw, double myp, int user)
	{
		 if(pw[user] == myp)  {
			 return true;
		 }
		return false;
	}

}