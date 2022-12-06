//Broc Williams && Justin Huang
//Wednesday, Nov 10, 2022
//Hon Prog, P1
//Desc function of Program

package Pack1;

import java.util.*;
import java.io.*;
public class Bank
{
   public static void main(String[] args)throws IOException
   {
	   Scanner bob = new Scanner(System.in);
	   Scanner fred = new Scanner(new File("bank.dat"));
	   ckUserID ckid = new ckUserID();
	   ckPW ckpw = new ckPW();
     
	   String[] fname = new String[5];
	   String[] lname = new String[5];
	   int[] acct = new int[5];
	   double[] pw = new double[5];
	   double[] ckbal = new double[5];
	   double[] svbal = new double[5];
	   double[] loans = new double[5];
      
	   CKbal bal = new CKbal();
	   SVbal sbal = new SVbal();
     
	   int i = 0;
	   while(fred.hasNext())
	   {
		   fname[i]=fred.next();
		   lname[i]=fred.next();
		   acct[i]=fred.nextInt();
		   pw[i]=fred.nextDouble();
		   ckbal[i]=fred.nextDouble();
		   svbal[i]=fred.nextDouble();
		   loans[i]=fred.nextDouble();
		   i++;
      }
     
	   //fname
	   for(int j = 0; j <fname.length; j++)
	   {
		   System.out.print(fname[j] + " ");
		   System.out.print(lname[j] + " ");
		   System.out.print(acct[j] + " ");
		   System.out.print(pw[j] + " ");
		   System.out.print(ckbal[j] + " ");
		   System.out.print(svbal[j] + " ");
		   System.out.print(loans[j] + " ");
		   System.out.println();
	   }
	   System.out.println();
	   boolean login1 = false;
	   while(login1 == false)  {
		   System.out.println("Enter your User ID");
		   int id = bob.nextInt();
		   int account = ckid.findID(acct, id);
		   boolean found = ckid.ckMyid(acct, id);
		   if (found)
		   {
			   System.out.println("Account successfully found");
			   int chances = 3;
			   login1 = true;
			   boolean login = false;
			   while(chances >= 0)  {
				   System.out.println("Please enter your password");
				   double myp = bob.nextDouble();
				   boolean foundpw = ckpw.ckMypw(pw, myp, account);
				   if(foundpw)  {
					   System.out.println("Correct password. Welcome, " + fname[account]);
					   login = true;
					   break;
				   }else  {
					   System.out.println("Incorrect password. " + chances + " attempts left.");
					   chances--;
				   }
			   }
			   if(login)  {
				   while(true)  {
					   System.out.println("Which account would you like to access?");
					   System.out.println("1 - Savings, 2 - Checkings 3 - Exit");
					   int acc = bob.nextInt();
					   if(acc == 1)  {
						   //Nikhil
					   }else if(acc == 2)  {
						   System.out.println("What would you like to check on your checkings account?");
						   System.out.println("1 - Balance, 2 - Deposit, 3 - Withdraw");
						   int option = bob.nextInt();
						   if(option == 1)  {
							   System.out.println("Your current checkings balance is: $" + bal.balance(ckbal, account));
						   }else if(option == 2)  {
							   System.out.println("How much would you like to deposit?");
							   double depo = bob.nextDouble();
							   System.out.println("$" + depo + " deposited. Your new balance is $" + bal.deposit(ckbal, account, depo));
							   ckbal[account] = bal.deposit(ckbal, account, depo);
						   }else if(option == 3)  {
							   System.out.println("How much would you like to withdraw?");
							   double with = bob.nextDouble();
							   if(ckbal[account] >= with)  {
								   System.out.println("$" + with + " withdrawn. Your new balance is $" + bal.withdraw(ckbal, account, with));
								   ckbal[account] = bal.withdraw(ckbal, account, with);
							   }else  {
								   System.out.println("You do not have enough in your balance to withdraw that much. Try again.");
							   }
						   }
					   }else if(acc == 3)  {
						   break;
					   }else  {
						   System.out.println("That is not an option. Please try again.");
					   }
				   }
			   }else  {
				   System.out.println("Incorrect password.");	
			   }
		   }
		   else
		   {
			   System.out.println("Account not found. Please try again.");
		   }
	   }
	   System.exit(0);
   	}
}