import java.util.Scanner;

public class Shell extends GasStation {

    public Shell(String[] acceptedCards, String cardUsed, boolean hasCarwash,
                    String gasStationName, String gasStationLocation) {
   
        super(acceptedCards, cardUsed, hasCarwash, gasStationName, gasStationLocation);
        gasPrice = 1.99;
        if (hasCarwash == true)
            priceOfCarwash = 17.00; 
    }

}
