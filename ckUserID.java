package Pack1;

//ID

public class ckUserID

{

	public ckUserID()

	{



	}

	public boolean ckMyid(int[]acct, int id)

	{

		boolean found = false;

		

		 for(int j = 0; j < acct.length; j++)

		 {

			 if(acct[j] == id)

			 {

				 found = true;

			 }

		 

		 }

		

		return found;

	}
	
	public int findID(int[] acct, int id)  {
		for(int i = 0 ; i < acct.length ; i++)  {
			if(acct[i] == id)
			{
				return i;
			}
		}
		return -1;
	}



}

