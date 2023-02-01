import java.util.*;

class bank{
	
	Scanner sc = new Scanner(System.in);
	String name,trans="";
	int acc_no,pin;
	
	public float register() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("\n-------------------------------------------");
		System.out.print("\nEnter your name : ");
		name=sc.nextLine();
		System.out.print("\nEnter your account number : ");
		acc_no=sc.nextInt();
		System.out.print("\nEnter your pin : ");
		pin=sc.nextInt();
		System.out.print("\nEnter the starting balance :");
		float balance=sc.nextFloat();
		System.out.println("\nRegistration completed..");
		System.out.println("-------------------------------------------");
		return balance;
	}
	
	public int login() {
		
		String lname;
		int lpin,flag=0;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("\n-------------------------------------------");
		System.out.print("\nEnter your user name : ");
		lname=sc.nextLine();
		System.out.print("\nEnter your pin : ");
		lpin=sc.nextInt();
		if(name.equals(lname) && pin==lpin) {
			System.out.println("\nLogged in successfully..");
			flag=1;
		}
		System.out.println("-------------------------------------------");
		return flag;
		
	}
	
	public void displayBalance(float balance){
		System.out.print("\nCurrent Balance : "+balance);
	}
	
	public float withdrawing(float balance) {
		
		float withdraw;
		System.out.println("\n----------Withdraw Operation-----------\n");
		System.out.print("\nEnter the amount for withdrawl :");
		withdraw=sc.nextFloat();
		System.out.print("\nWithdrawing amount : "+withdraw);
		if(balance>=withdraw) {
			balance=balance-withdraw;
			System.out.println("\n\nPlease collect your money and collect the card");
			displayBalance(balance);
			String s=withdraw + " Rs withdrawn\n";
			trans=trans.concat(s);
		}
		else {
			System.out.println("\nSorry! Insufficient balance..");
		}
		System.out.println("-------------------------------------------");
		return balance;
		
	}
	
	public float deposit(float balance) {
		
		float deposit;
		System.out.println("\n------------Deposit Operation-----------------\n");
		System.out.print("\nEnter the amount for deposit :");
		deposit=sc.nextFloat();
		System.out.print("\nDepositing amount : "+deposit);
		balance=balance+deposit;
		System.out.println("\n\nYour money has been successfully deposited");
		String s=deposit + " Rs deposited\n";
		trans=trans.concat(s);
		displayBalance(balance);
		System.out.println("-------------------------------------------");
		return balance;
		
	}
	
	public float transfer(float balance) {
		
		float transfer;
		int an;
		String tname;
		System.out.println("\n------------Transfer Operation-----------------\n");
		System.out.print("\nEnter the account number for transfer : ");
		an=sc.nextInt();
		System.out.print("\nEnter the name : ");
		tname=sc.next();
		System.out.print("\nEnter the amount to transfer : ");
		transfer=sc.nextFloat();
		if(transfer<=balance) {
			balance=balance-transfer;
			System.out.println("\nYour money has been successfully transferred");
			displayBalance(balance);
			String s=transfer + " Rs transferred to "+tname+"\n";
			trans=trans.concat(s);
		}
		else {
			System.out.println("\nSorry! Insufficient balance for transfer..");
		}
		System.out.println("-------------------------------------------");
		return balance;
	}
	
	public void transHistory() {
		System.out.println("\n-----------TRANSACTION HISTORY-------------\n");
		System.out.println(trans);
		System.out.println("-------------------------------------------");
	}
}
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch,ch1,ch2,i=0;
				
		bank b1=new bank();
		System.out.println("\n-------------------WELCOME TO SBI ATM-----------------------");
			do {
				System.out.println("\n1.Register\n2.Exit");
				System.out.print("\nEnter your choice : ");
				ch=sc.nextInt();
				switch(ch) {
					case 1 :
						float balance=b1.register();
						System.out.println("\nPlease proceed to login..");
						do {
							System.out.println("\n1.Login\n2.Exit");
							System.out.print("\nEnter your choice : ");
							ch1=sc.nextInt();
							switch(ch1) {
								case 1 :
									int flag = b1.login();
									if(flag==1) {
										do {
											System.out.println("\n\n1.Display balance\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Transaction history\n6.Quit");
											System.out.print("\nEnter your choice : ");
											ch2=sc.nextInt();
											switch(ch2) {
												case 1 :
													b1.displayBalance(balance);
													break;
												case 2 :
													balance=b1.withdrawing(balance);
													break;
												case 3 :
													balance=b1.deposit(balance);
													break;
												case 4 :
													balance=b1.transfer(balance);
													break;
												case 5 :
													b1.transHistory();
													break;
												default :
													if(ch2!=6) {
														System.out.println("\nWrong choice...");
													}	
											}
										}while(ch2!=6);
								}
								else {
									System.out.println("\nPlease enter the correct details..");
								}
								break;
							default :
								if(ch1!=2) {
									System.out.println("\nWrong choice...");
								}	
						}
						}while(ch1!=2);
						break;
					case 2 :
						System.exit(0);
					default :
						System.out.println("\nWrong choice...");	
				}
			}while(ch!=2);
	}

}
