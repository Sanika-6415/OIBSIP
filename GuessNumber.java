import java.util.*;

class Number{
	static int i=-1;
	int score;
	public void guessNumber(int attempts,int number) {
		
		Scanner sc = new Scanner(System.in);
		for(i=0;i<attempts;i++) {
			
			System.out.print("Guess the number : ");
			int n=sc.nextInt();
			
			if(number==n) {
				System.out.println("Number is matched.");
				break;
			}
			
			else if(number<n){
				System.out.println("Entered number is higher than generated number.");
			}
			
			else if(number>n) {
				System.out.println("Entered number is lower than generated number.");
			}
			
		}
		if(i==attempts) {
			System.out.println("Your attempts are over.");
		}
	}
	
	public void score() {
		if(i==0) {
			score=score+50;
		}
		else if(i==1) {
			score=score+30;
		}
		else if(i==2) {
			score=score+20;
		}
		else if(i==3) {
			score=score+10;
		}
		else if(i==4) {
			score=score+5;
		}
		System.out.println("Your score is : "+score);
	}
}
public class GuessNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int min=1;
		int max=100;
		int attempts=5,ch;
		   
		do {
			System.out.println("\n1.Play the game\n2.Display the score\n3.Exit");
			System.out.print("\nEnter the choice :");
			ch=sc.nextInt();
			Number n1=new Number();
			switch(ch) {
				case 1:
					int number=(int)(Math.random()*(max-min+1)+min);
					n1.guessNumber(attempts, number);
					break;
				case 2:
					n1.score();
					break;
				case 3:
					System.exit(0);
				default :
					System.out.println("Wrong choice...");
			}
		}while(ch!=3);
	}

}
