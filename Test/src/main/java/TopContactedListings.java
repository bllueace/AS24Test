import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopContactedListings {

    Map<Integer, Integer> topFrqSorted = new LinkedHashMap<>();

    public void MostContactedListings(Collection<Listing> listing, Collection<Contacts> contacts) {

        findMostContacted(contacts);
        getAverageTop30Price(listing, contacts);
    }

    private void findMostContacted(Collection<Contacts> contacts) {

        Collection<Integer> ids = new ArrayList<>();


        for (Contacts contact : contacts) {
            ids.add(contact.getContact_id());
        }

        Set<Integer> distinct = new HashSet<>(ids);

        //get the number for 30%
        int thirtyPercent = (distinct.size() / 100) * 30;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (Integer id : ids) {
            Integer count = frequencies.get(id);
            if (count == null)
                count = 0;

            frequencies.put(id, count + 1);
        }


        frequencies.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(thirtyPercent)
                .forEachOrdered(x -> topFrqSorted.put(x.getKey(), x.getValue()));

        //System.out.println(ids);

    }

    private void getAverageTop30Price(Collection<Listing> listingList, Collection<Contacts> contacts) {

        Map<Integer, Integer> listings = new HashMap<>();
        int totalPrice = 0;

        for (Listing lst : listingList) {
            for (Map.Entry<Integer, Integer> cnt : topFrqSorted.entrySet()) {
                if (lst.getId() == cnt.getKey()) {
                    totalPrice += lst.getPrice();
                }
            }
        }

        int avrgPrice = getAverageSum(totalPrice, topFrqSorted.size());


        String leftAlignFormat = "| %-15s  |%n";

        System.out.format("+-------------+----+%n");
        System.out.format("|Average in Euro   |%n");
        System.out.format("+-------------+----+%n");

        System.out.format(leftAlignFormat, getCurrency(avrgPrice));

        System.out.format("+-------------+----+%n");


       // System.out.println(avrgPrice);
    }

    private int getAverageSum(int total, int lstSize) {
        return total / lstSize;
    }
    private String getCurrency(int cur){
        double price = cur;
        NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.GERMANY);
        String currency = formatter.format(price);

        return currency;
    }

}
