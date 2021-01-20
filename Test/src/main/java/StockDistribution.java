import java.util.*;

public class StockDistribution {

    public void stockDistribution(Collection<Listing> listingList){

        Collection<String> carMakeList = new ArrayList<>();
        int totalListings = 0;
        float percentages = 0.0f;

        for(Listing lst : listingList){
            carMakeList.add(lst.getMake());
            totalListings++;
        }

        Set<String> uniqueCarMakes = new HashSet<String>(carMakeList);

        String leftAlignFormat = "| %-15s | %-13s |%n";
        System.out.format("+-------------+-------------------+%n");
        System.out.format("| Car Make    | Distribution      |%n");
        System.out.format("+-------------+-------------------+%n");

        for(String make : uniqueCarMakes)
        {
            percentages = (getOccurrences(make,listingList) / totalListings)*100;


            System.out.format(leftAlignFormat, make, percentages + "%");

            //System.out.println("How many " + make + " : " + getOccurrences(make, listingList) + " of which percentage is : " + percentages + "%");
        }

        System.out.format("+-------------+-------------------+%n");



        //System.out.println("List of unique car makes: " + uniqueCarMakes);
    }

    private float getOccurrences (String make, Collection<Listing> lstListings){

        float occurrences = 0;

        for(Listing lst : lstListings)
        {
            if(lst.getMake().equals(make))
                occurrences++;
        }

        return occurrences;
    }
}
