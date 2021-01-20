import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ListingData lstData = new ListingData();
        ContactsData contData = new ContactsData();
        AverageListingPrice avg = new AverageListingPrice();
        StockDistribution stckDist = new StockDistribution();
        TopContactedListings topContacted = new TopContactedListings();

        System.out.println("Hello, please choose a command to run:");
        System.out.println("\n 1) Display average listing price");
        System.out.println("\n 2) Display stock Distribution");
        System.out.println("\n 3) Display average price of most contacted listings");

        int userInput = input.nextInt();

        lstData.run();
        contData.run();

        if (userInput == 1)
            avg.averageListingPrice(lstData.getListinglst());

        if (userInput == 2)
            stckDist.stockDistribution(lstData.getListinglst());

        if (userInput == 3)
            topContacted.MostContactedListings(lstData.getListinglst(), contData.getContactsData());

        input.nextInt();
    }

}
