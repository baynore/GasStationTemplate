import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public abstract class GasStation {
    
    protected boolean hasCarwash;
    protected String[] acceptedCards;
    protected double priceOfCarwash;
    protected double gasPrice;
    protected String cardUsed;
    protected String gasStationName;
    protected String gasStationLocation;
	
	boolean wantCarwash;
	boolean isCardValid;
	double gasTotal;

    public GasStation(String[] acceptedCards, String cardUsed, boolean hasCarwash,
                      String gasStationName, String gasStationLocation) {
        
        this.acceptedCards = acceptedCards;
        this.cardUsed = cardUsed;
        this.hasCarwash = hasCarwash;
        this.gasStationName = gasStationName;
        this.gasStationLocation = gasStationLocation;
    
    }

    public final void printReceipt() {
    
        System.out.println("Your " + gasStationName + " located in " + gasStationLocation);
        swipeOrInsertCard();
        validateCard();
        if (isCardValid == true) {
            creditOrDebit();
            calculateTotal();
            if (hasCarwash == true)
                carwashValid();
            receipt();
            endTransaction();
        }

    }

    public final void swipeOrInsertCard() {
    
        System.out.println("Please swipe or insert card...");
    
    }
    
    public final void validateCard() {
        
        isCardValid = false;
        List al = Arrays.asList(acceptedCards);

        if (al.contains(cardUsed)) {
            isCardValid = true;
        }
        
        if (isCardValid) {
            System.out.println("Card is valid!");
        }
        else if (!isCardValid) {
            System.out.println("Card is not valid! Please try another card. Cancelling transaction...");
        }

    }
    
    public final void creditOrDebit() {
        
        System.out.print("Is this a credit card? Please enter y or n: ");
        Scanner sc = new Scanner(System.in);
        String cardType = sc.nextLine();
        boolean isValid = false;

        do { 
               
            if (cardType.toLowerCase().equals("y")) {
                
                System.out.print("Please enter your zip code: ");
                String zipCode = sc.nextLine();
                isValid = true;

            }
            else if (cardType.toLowerCase().equals("n")) {
        
                System.out.print("Please enter your pin number: ");
                String pinNumber = sc.nextLine();
                isValid = true;
        
            }
            else if (!isValid){
                
                System.out.print("Invalid input! Please enter y or n: ");
                cardType = sc.nextLine();
            
            }
        } while (!isValid);
           
    } 

    public void carwashValid() {
   
        System.out.print("Would you like to go through the carwash? Please enter y or n: ");
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean isValid = false;
        wantCarwash = false;

        do {
            if (input.toLowerCase().equals("y")) {
                System.out.println("Okay, that'll be $" + String.format("%.2f", priceOfCarwash) + ". It will be added to your receipt.");
                isValid = true;
                wantCarwash = true;
            }
            else if (input.toLowerCase().equals("n")) {
                System.out.println("Okay then... :(");
                isValid = true;
                wantCarwash = false;
        
            }
            else if (!isValid)
                System.out.println("Invalid input! Please enter y or n.");
        } while (!isValid);

    
    }
    
    public void calculateTotal() {
    
        System.out.print("How many gallons of gas would you like? ");
        
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        gasTotal = gasPrice * input;
         
        System.out.println("Okay, that'll be $" + String.format("%.2f", gasTotal) + ". It will be added to your receipt.");
         
    }

    public final void receipt() {
    
        System.out.printf("Total: $%.2f", gasTotal);
        if (hasCarwash == true && wantCarwash == true)
            System.out.printf(" + $%.2f = $%.2f", priceOfCarwash, priceOfCarwash + gasTotal);
    }

    public final void endTransaction() {
    
        System.out.println("\nThank you for pumping up your life with " + gasStationName + " :)");
    
    }
}
