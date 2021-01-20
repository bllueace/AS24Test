import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ListingData {

/*    private int avrgPrivate = 0;
    private int avrgDealer = 0;
    private int avrgOther = 0;*/

    private Collection<Listing> listingsList;

    public void run(){
        listingsList = readListingCSV_in_memory("listings.csv");

    }

    private List<Listing> readListingCSV_in_memory(String fileName) {
        List<Listing> listing = new ArrayList<>();

        try {

            // Creates a FileReader
            FileReader file = new FileReader(fileName);
            // Creates a BufferedReader
            BufferedReader br = new BufferedReader(file);

            //skip column names
            br.readLine();
            String line = null;

            // loop until all lines are read to memory
            while ((line = br.readLine()) != null) {

                //Ignore the double quotes for strings
                line = line.replaceAll("\"", "");

                // use string.split to populate string array
                String[] attributes = line.split(",");

                //create listing object
                Listing listings = createListing(attributes);
                // adding listing into ArrayList
                listing.add(listings);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

            // Closes the reader
            br.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return listing;
    }

    private static Listing createListing(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String make = metadata[1];
        int price = Integer.parseInt(metadata[2]);
        int mileage = Integer.parseInt(metadata[3]);
        String seller_type = metadata[4];

        // create and return listing of this metadata
        return new Listing(id, make, price, mileage,seller_type);
    }

    public Collection<Listing> getListinglst(){
        return listingsList;
    }
}
