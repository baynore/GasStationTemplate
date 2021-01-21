import java.util.Scanner;

public class Speedway extends GasStation {

    public Speedway(String[] acceptedCards, String cardUsed, boolean hasCarwash,
                    String gasStationName, String gasStationLocation) {
   
        super(acceptedCards, cardUsed, hasCarwash, gasStationName, gasStationLocation);
        gasPrice = 2.05;
        if (hasCarwash == true)
            priceOfCarwash = 15.00;

    }

}
