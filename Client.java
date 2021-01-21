
public class Client {

    public static void main(String[] args) {
    
        Speedway s = new Speedway(new String[] {"Visa", "Mastercard", "Discover"},
                                  "Visa", true, "Speedway", "Boone, NC");
        
                                   
        Shell sh = new Shell(new String[] {"Visa", "Mastercard"}, "Mastercard", false,
                             "Shell", "Hillsborough, NC");
        
        Shell sh1 = new Shell(new String[] {"Visa", "Mastercard"}, "Discover", true,
                             "Shell", "Raleigh, NC");

        s.printReceipt();
        System.out.println();

        sh.printReceipt();
        System.out.println();

        sh1.printReceipt();
        System.out.println();

    }

}
