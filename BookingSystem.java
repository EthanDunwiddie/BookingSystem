import java.util.Scanner;
import java.util.ArrayList;
/*

This is a demo of a restaurant booking system (prototype)

Requirements:
0. Ask for the customers name
1. Customer chooses seating
2. Display a menu
	- Food
	- Drinks
	- Item code
	- Price
	- Quantity
3. Order/Basket
	- Add items
	- Remove items
	- Check quantity
4. Checkout
5. Confirmation

---------------------------------------------------------------------------------------------------------------------

	Algorithm
	
Start
0. Ask for the customers name
1. Customer chooses seating:
	- Ask if customer wants to choose a seat (01 - 41)
	- Can only choose from available seating (seating already reserved cannot be assigned to while its reserved)
	- Reserved seats should be marked with an "XX"
	- Otherwise the customer is allocated to the next available seat 
2. Display a menu:
	- Item (food, drinks)
	- Code (for the item)
	- Price
	- Quantity
3. Order/Basket
	- Add items from menu to basket (ask for item code and quantity)
	- Remove items from basket (ask for item code and quantity) 
	- Check if the quantity is higher than stock - if so reject order otherwise add to basket
4. Checkout
	- Display the total cost
	- Final checkout (ask for payment) 
	- Empty basket after successful payment 
	- Reject order if payment unsuccessful or payment amount is less than the cost of the order
5. Confirmation message:
	- Display customers name
	- Seat number 
	- List of ordered items
	- Total cost of the order

----------------------------------------------------------------------------------------------------

Errors/things that still need finishing:
	- after initial run/loop the menu and seating run multiple times
	- make code choose next available seat if option is chosen
	- remove items method doesnt remove items
	- make it empty basket after purchase

*/

public class BookingSystem {
	
	//Deals with the inputs
	static Scanner input = new Scanner(System.in);
	
	//Arrays used to hold the menu items name, code, price, quantity, and seat
	static ArrayList<String>  itemName  = new ArrayList<String>();//Name
	static ArrayList<Integer> itemCode  = new ArrayList<Integer>();//Code
	static ArrayList<Float>   itemPrice = new ArrayList<Float>();//Price
	static ArrayList<Integer> itemQty   = new ArrayList<Integer>();//Quantity
	static ArrayList<String>  Seat      = new ArrayList<String>();//Seat

	//Holds information for the basket 
	static ArrayList<String>  basketName  = new ArrayList<String>();//Name
	static ArrayList<Integer> basketCode  = new ArrayList<Integer>();//Code
	static ArrayList<Float>   basketPrice = new ArrayList<Float>();//Price
	static ArrayList<Integer> basketQty   = new ArrayList<Integer>();//Quantity


	public static void main(String[] args) {
		String Name;
		int Start;
		
			//Seating array
		String seating[][] = {{"01", "02", "03", "04", "05", "06", "07"},
				  {"08", "09", "10", "11", "12", "13", "14"},
				  {"15", "16", "17", "18", "19", "20", "21"},
				  {"22", "23", "24", "25", "26", "27", "28"},
				  {"29", "30", "31", "32", "33", "34", "35"},
				  {"36", "37", "38", "39", "40", "41", "42"},
				  {" ", " ", " ", " ", " ", " ", " "}};//last column wouldn't print out without this row
	
		
		while(true){
				//0. Ask for the customers name	
			System.out.println("PLease enter your name");
			Name = input.next();
	
			
				//Prints out the seating arrangement - each seat enclosed by []
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j <= 6; j++) {
					System.out.print("[" + seating[i][j] + "]");
				}
				System.out.println();
			}//End of for loop
			
			
				//Asks customer if they wish to book a seat
			System.out.println("Would you like to reserve a seat? \t1:Yes \t2:No");
			Start = input.nextInt();
			
			
			if(Start == 1) {
				System(seating);
				
				Menu();
				
				Basket();
				
				Confirmation(Name);
				
			}
			else {
				break;
			}
			

			// break;
			
		}//End of while loop
		
	}//End of main method


	//1. Customer chooses seating
	private static void System(String[][] seating) {
		int seatChoice, X, Y;
		String seatNum, seat;
		
		//Decides between choice of seat or automatic choice
		System.out.println("Would you like to choose the seat? \t1:Yes \t2:No");
		seatChoice = input.nextInt();
		
		switch(seatChoice) {
		
		case 1:
/*			
	Test for picking seat number
	
			System.out.println("Please choose a seat");
			seatNum = input.next();	
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j <= 6; j++) {
					if(seating[i][j].contentEquals(seatNum)) {
						//Assigns XX to chosen seat
						seating[i][j] = "XX"; //Assigns seat position with XX
					}//End of if seating = seatNum
				}
			}//End of for loops
*/			
			
			
			//Asks customer which seat they would like (using coordinates)
			System.out.println("Please enter an x coordinate");
			X = input.nextInt();
			
			System.out.println("Please enter a y coordinate");
			Y = input.nextInt();
			
				//Checks if position = XX already 
			if(seating[Y][X].contentEquals("XX")) {
				//If position = XX then this method is ran again until the user enters available seat
				System.out.println("This seat is already reserved, try again");
				System.out.println();
				System(seating);
				break;
			}
			
			Seat.add(seating[Y][X]);
			seating[Y][X] = "XX"; //Assigns seat position with XX
			break;
			
		case 2:
			//Iterates through the array seating
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 6; j++) {
					
					//Apply XX to next available seat
					
					seating[0][0] = "XX"; // Temporary

				}
			}//End of for loop
			break;
			
		}//End of switch
		
			
			//Prints out the seating arrangement - each seat enclosed by []
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j <= 6; j++) {
				System.out.print("[" + seating[i][j] + "]");
			}
			System.out.println();
		}//End of for loop
			
	}//End of System method

	
	//2. Menu
	private static void Menu() {
		//Display a menu - item, code, price, quantity
		System.out.println("\n\t\t|Menu|");
		
		itemName.add("Pizza\t");
		itemCode.add(1);
		itemPrice.add((float) 10.00);
		itemQty.add(50);
		
		itemName.add("Steak\t");
		itemCode.add(2);
		itemPrice.add((float) 7.00);
		itemQty.add(50);
		
		itemName.add("Sandwich");
		itemCode.add(3);
		itemPrice.add((float) 5.00);
		itemQty.add(50);
		
		itemName.add("Water\t");
		itemCode.add(4);
		itemPrice.add((float) 1.00);
		itemQty.add(30);
		
		itemName.add("Soft drink");
		itemCode.add(5);
		itemPrice.add((float) 2.00);
		itemQty.add(30);
		
		itemName.add("Tea\t");
		itemCode.add(6);
		itemPrice.add((float) 2.00);
		itemQty.add(20);
		
		itemName.add("Coffee");
		itemCode.add(7);
		itemPrice.add((float) 2.00);
		itemQty.add(20);
		
		itemName.add("Ice cream");
		itemCode.add(8);
		itemPrice.add((float) 2.00);
		itemQty.add(20);
		
		itemName.add("Chocolate");
		itemCode.add(9);
		itemPrice.add((float) 2.00);
		itemQty.add(20);
	
		
		System.out.println( "Code \t: Name \t\t: Price \t: Qty" );
		for( int i=0; i< itemName.size(); i++ ) {
		
		System.out.println(itemCode.get(i) + " \t: " + itemName.get(i) + "\t: " + itemPrice.get(i) + " \t\t:" + itemQty.get(i));	
		
		}
	}//End of Menu method
	
	
	//3. Basket
	private static void Basket() {
		int tempItemCode, tempItemQty;
		
		while(true) {	
			//Ask the user to enter item code
			System.out.println("Please enter an item code to select the item, 0 for checkout, or -1 to remove items");
			//Enter item code - adds the item to the basket
			tempItemCode = input.nextInt() ;  
			
	 		if(tempItemCode == 0) {     
				   Checkout();
				 //Termination point
				 break;
			}
	 		else if(tempItemCode == -1) {
	 			removeItem();
	 			break;
	 		}
			else {
				//Converts from item code to the position of it in the array
				tempItemCode = tempItemCode - 1;
				
				//Asks for quantity
				System.out.println("How many would you like to order?");
				tempItemQty = input.nextInt();
				
			 //	Checks if there is enough
				if(itemQty.get(tempItemCode) >= tempItemQty ) {			
					//If enough then add it to the basket
					addItem(tempItemCode, tempItemQty);
					}
	 			else{
	 				System.out.println("Not enough stock");
	 			}
				displayOrder();
			}
	 		
		}
	}//END of basket


	//4. Checkout
	private static void Checkout() {
		float bill = 0, amount, excess, change;
		
		//Total cost of the order/basket
		for( int i=0; i< basketName.size(); i++ ) {
			bill += basketPrice.get(i); 
		}
			
		//Display the bill
		System.out.println("Total cost is " + bill);
			
		//Ask the user to enter the amount payed
		System.out.println("Please enter the amount being paid");
			
		//Get the amount from the customer
		amount = input.nextFloat();
			

		//If there is change, gives customer their change
		if(amount > bill) {
			System.out.println("Your change is  " + (amount - bill) );
				
			//Asks them to take their seat
			System.out.println("Thank you, please take your seat.");
			System.out.println();
		}//End of if statement
			
		//If customer enters less than cost
		else if(amount < bill) {
			change = bill - amount; //The difference between the cost of the bill and the amount entered by the user.
				
			//Iterates until the user has entered enough money to pay for the items
			for(int i=0; change<=bill; i++) {
				System.out.println("You have not paid the full amount \nPlease enter the other £" + change);
				excess = input.nextFloat();
				change = change - excess;
					
				//If the user enters enough money, they will receive their change
				if(change <= 0) {
					System.out.println("Your change is £" + (change*-1));//Converts left over change into positive number
					break;
				}
			}//End of for loop
			System.out.println("Thank you, please take your seat. \n");
		}//End of if else
		
		
		
		
		
	}// End of payment method
	
	
	//5. Confirmation message
	private static void Confirmation(String Name) {
		float bill = 0;
		
		//Total cost of the order/basket
		for( int i=0; i< basketName.size(); i++ ) {
			bill += basketPrice.get(i); 
		}
		
		
		
		//Start of receipt
		System.out.println("-----------------------\n\tReceipt\n-----------------------");
		
		//Prints customers name
		System.out.println(Name + "\n");
		
		//Prints customers seat number
		System.out.println("Seat number:\t" + Seat);
		
		//Prints customers order
		System.out.println("\nOrder:");
		for( int i=0; i< basketName.size(); i++ ) {
			System.out.println(basketName.get(i) + "\tx" + basketQty.get(i) + "\t:£" + basketPrice.get(i));
		}
		
		//Prints out the total cost
		System.out.print("\nTotal: £" + bill + "\n");
		
		//End of receipt
		System.out.println("-----------------------");
		
	}//End of Confirmation method
	
	
	//Lets customer remove items they no longer want
	private static void removeItem() {
		//Displays the current order
		displayOrder();
		int tempItemCode, tempItemQty;
		
		//User enters the code for the item they want to remove
		System.out.println("Please enter an item code to select an item");
		tempItemCode = input.nextInt();
		
		//User enters the amount of the chosen item they wish to remove
		System.out.println("How many would you like to remove?");
		tempItemQty = input.nextInt();
			
		//Removes chosen items and quantity 
		basketCode.remove(tempItemCode);
		basketName.remove(itemName.get(tempItemCode));
		basketQty.remove(tempItemQty);
		basketPrice.remove(tempItemQty * itemPrice.get(tempItemCode));
		
		
		
		
		
		Basket();
	}

	
	//Adds input items to the basket
	private static void addItem(int tempItemCode, int tempItemQty) {
		basketCode.add(tempItemCode + 1);
		basketName.add(itemName.get(tempItemCode));
		basketQty.add(tempItemQty);
		basketPrice.add(tempItemQty * itemPrice.get(tempItemCode));
	}//End of method
	
	
	//Displays the items you order 
	private static void displayOrder() {
			
		System.out.println("Code \t: Name \t\t: Price \t: Qty");
		
			for( int i=0; i< basketName.size(); i++ ) {
				System.out.println(basketCode.get(i) + " \t: " + basketName.get(i) + "\t: " + basketPrice.get(i) + " \t\t:" + basketQty.get(i)  );		
			}
	}//End of display order method

	
}//End of bookingSystem class
