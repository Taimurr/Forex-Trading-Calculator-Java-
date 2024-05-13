// Taimur Rizwan
// This program is designed to estimate the average portfolio growth expectancy based on the user's
// trading account capital and the percentage they're willing to risk
import java.util.*;


public class CompoundCalculator {

	public static void maxPipCalc() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Trading Capital ($): ");
		double capital = input.nextDouble();
		
		System.out.printf("Enter your Desired Profit ($) at 10 pips: ");
		double desiredProfit = input.nextDouble();
		
		double accountRiskP1 = desiredProfit / capital;
		double accountRisk = accountRiskP1 * 100;
		
		System.out.println("Risk = " + accountRisk + "%");
		
		System.out.printf("At $" + capital + " Trading Capital and making $" + desiredProfit + " profit...\n");
		double totalDrawdownPipsP1 = (capital / desiredProfit);
		double total = 10 * totalDrawdownPipsP1;
		System.out.printf("Maximum Drawdown = " + total + " pips\n");
		
		System.out.println("1 for Redo | 2 for Main Menu");
		int universalOption = input.nextInt();
		
		if (universalOption == 1) {
			maxPipCalc();
		}
		
		else if (universalOption == 2) {
			main(null);
		}
		if (universalOption > 2 || universalOption < 1) {
			System.out.println("Invalid option!");
		}
	}
	
	public static void CompoundingGrowth() {
		
		Scanner input = new Scanner(System.in);  
		
		System.out.println("Enter your Initial Trading Capital ($): ");
		double initialCapital = input.nextDouble();
		System.out.println("Enter your Account Risk (%): ");
		double accountRisk = input.nextDouble();
		double riskPercentage = accountRisk / 100.0;
		//For Compounding Growth Function
		int endOfWeek = 4;
		int endOfMonth = 16;
		int endOfYear = 12;
		double profitPerTrade =  (initialCapital * riskPercentage);
		int profitPerWeek = (int) (profitPerTrade * endOfWeek);
		int profitPerMonth = (int) (profitPerTrade * endOfMonth);
		int profitPerYear = profitPerMonth * endOfYear;
		

		
		System.out.println("Initial Trading Capital: " + " " + "is" + " " + "$" + initialCapital + "\n");
		System.out.println("My account risk is: " + " " + accountRisk + "%" + "\n");
		System.out.println("Capital invested per month = " + " " + "$" + initialCapital + "\n");
		System.out.println("Approximate profit accumulated =  " + "$" + profitPerTrade + "\n");
		
		double compound = initialCapital;

		int dayCounter = 1;
		
		for(int i = 1; i <= endOfMonth; i++) {
			
			profitPerTrade = (compound * riskPercentage); //Calculating daily profits (iterative step)
			compound += profitPerTrade; //Compounding profits
			
				System.out.println("Total Money in the Account after Day: " + (dayCounter++) + " is"  + " " + "$" + compound);
				System.out.println("\n");
					
		}

		
		
		
		Scanner newInput =new Scanner(System.in); 
		System.out.println("Continue? \n 1 Yes | 2 Restart | 3 Main Menu");
		int option = input.nextInt();
		
		if(option == 1) {
			
			Scanner numDays = new Scanner(System.in);
			System.out.println("Please enter the number of days: ");
			int storeNumDays = input.nextInt();
			
			System.out.println("Loading the next " + storeNumDays + " results...");
			for(int i = 1; i <= storeNumDays; i++) {
				
				profitPerTrade = (compound * riskPercentage);
				compound += profitPerTrade;
				
					System.out.println("Total Money in the Account after Day: " + (dayCounter++) + " is"  + " " + "$" + compound);
					System.out.println("\n");
					
			}
			//Everything was perfect, then I wrote this...
			Scanner secondOptionScan = new Scanner(System.in);
			System.out.println("1 Redo | 2 Main Menu");
			int secondOption = input.nextInt();
			cycle(secondOption);
			
		}
		
		else if (option == 2) {
			CompoundingGrowth();
		}
		
		else if (option == 3) {
			main(null);
		}
		
		input.close();

		
	}
	
	public static void cycle(int secondOption) {
		
		if (secondOption == 1) {
			CompoundingGrowth();
		}
		
		else if (secondOption == 2) {
			main(null);
		}
		
		
		if (secondOption > 2 || secondOption < 1) {
			System.out.println("Invalid entry!");
		}
		
	}
	
	public static void FixedGrowth() {
		Scanner input =new Scanner(System.in);  
		
		System.out.println("Enter your Initial Trading Capital ($): ");
		double initialCapital = input.nextDouble();
		System.out.println("Enter your Account Risk (%): ");
		double accountRisk = input.nextDouble();
		double riskPercentage = accountRisk / 100.0;
		//For Fixed Growth Function
		int endOfWeek = 4;
		int endOfMonth = 16;
		int endOfYear = 12;
		int profitPerTrade = (int) (initialCapital * riskPercentage);
		int profitPerWeek = profitPerTrade * endOfWeek;
		int profitPerMonth = profitPerTrade * endOfMonth;
		int profitPerYear = profitPerMonth * endOfYear;
				
		
		System.out.println("Initial Trading Capital: " + " " + "is" + " " + "$" + initialCapital + "\n");
		System.out.println("My account risk is: " + " " + accountRisk + "%" + "\n");
		System.out.println("Capital invested per month = " + " " + "$" + initialCapital + "\n");
		System.out.println("Approximate profit accumulated =  " + "$" + profitPerMonth + "\n");
		
		double compound = initialCapital;
		
		
		for(int i = 1; i <= endOfYear; i++) {
			
			compound =  (compound + profitPerMonth);
			
			if(i == 12) {
				System.out.println("Total Money in the Account is " + " " + "$" + compound);
				System.out.println("\n");
				System.out.println("Total Profit for the Year is" + " " + "$" + (compound - initialCapital));
				
			}
			
			if(i < 12) {
				System.out.println("Total Account in Month: " + i + " " + "is" + " " + "$" + compound);
			}
			
		}
		
		System.out.println("1 for Redo | 2 for Main Menu");
		int universalOption = input.nextInt();
		
		if (universalOption == 1) {
			FixedGrowth();
		}
		
		else if (universalOption == 2) {
			main(null);
		}
		if (universalOption > 2 || universalOption < 1) {
			System.out.println("Invalid option!");
		}

		input.close();

	}
	

	
	public static void main(String[] args) {
		System.out.println("Welcome to the Day Trading Calculator!");
		
		System.out.println("Menu:");


		Scanner newInput = new Scanner(System.in);
		
		System.out.println("1 for Compounding Capital Strategy | 2 for Fixed Capital Strategy | 3 for Drawdown Calculator");
		int chosenMode = newInput.nextInt();
		
		if (chosenMode == 1) {
			CompoundingGrowth();
		}
		
		else if (chosenMode == 2) {
			FixedGrowth();
		}
		
		else if (chosenMode == 3) {
			maxPipCalc();
		}
		
		else if(chosenMode > 3 || chosenMode < 1) {
			System.out.println("Invalid entry!");
			return;
		}
		
		
	}
}
